/*
 *  http://www.lintcode.com/en/problem/connecting-graph-iii/
 *
 *  Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *  You need to support the following method:
 *      1. connect(a, b), an edge to connect node a and node b
 *      2. query(), Returns the number of connected component in the graph
 */

	public class ConnectingGraph3 {
		
		
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
		
		public ConnectingGraph3(int n) {
	        uf = new UF(n);
	    }

	    public void connect(int a, int b) {
	    		uf.union(a - 1, b - 1);
	    }

	    public int query() {
	    		return uf.cnt;
	    }
	}	
