/*
 *  http://www.lintcode.com/en/problem/connecting-graph-ii/
 *
 *  Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *  You need to support the following method:
 *      1. connect(a, b), an edge to connect node a and node b
 *      2. query(a), Returns the number of connected component nodes which include node a.
 */


	public class ConnectingGraph2 {
		
		
		private class UF {
			
			int[] id;
			int[] sz;
			int cnt;
			
			public UF (int n) {
				id = new int[n];
				sz = new int[n];
				for (int i = 0; i < n; i++) {
					id[i] = i;
					sz[i] = 1;
				}
				cnt = n;
			}
			
			int find (int x) {
				while (id[x] != x) {
					id[x] = id[id[x]];  // path compression
					x = id[x];
				}
				return id[x];
			}
			
			boolean connected (int x, int y) {
				return find(x) == find(y);
			}
			
			void union (int x, int y) {
				if (connected(x, y)) return;
				int left = find(x);
				int right = find(y);
				if (sz[left] > sz[y]) {
					id[right] = left;
					sz[left] += sz[right];
				} else {
					id[left] = right;
					sz[right] += sz[left];
				}
				cnt -= 1;
			}
		}


		UF uf;
		
		public ConnectingGraph2(int n) {
	        uf = new UF(n);
	    }

	    public void connect(int a, int b) {
	    		uf.union(a - 1, b - 1);
	    }

	    public int query(int a) {
	    		int id = uf.find(a - 1);
	    		return uf.sz[id];
	    }
	}
