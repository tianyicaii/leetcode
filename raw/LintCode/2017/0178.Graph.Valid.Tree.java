/* 
 *  http://www.lintcode.com/en/problem/graph-valid-tree/
 *
 *  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 *  write a function to check whether these edges make up a valid tree.
 */


	//  definition of tree: connected && !cycle
	//      connected: one connected component
	//      no cycle: number of edge == number of node - 1;
	
	public boolean validTree (int n, int[][] edges) {
		if (edges.length != n - 1) return false;

		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int[] e : edges) {  // add both directions
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();  // precondition: each node has a different label
		q.offer(0);  // start from any node, we can reach all the nodes. (connected)
		seen.add(0); // we can see a node only once, (no cycle)

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int e : graph.get(x)) {
				if (seen.contains(e)) continue;
				else {
					seen.add(e);
					q.offer(e);
				}
			}
		}
		return seen.size() == n;
	}


// uf
	class UF {
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
		boolean connected(int x, int y) {
			return find(x) == find(y);
		}
		int find (int x) {
			while (id[x] != x) {
				int grand = id[id[x]];  // path compression
				id[x] = grand;
				x = id[x];
			}
			return x;
		}
		void union (int x, int y) {
			if (connected(x, y)) return;
			int left = find(x);
			int right = find(y);
			if (sz[left] < sz[right]) {
				id[left] = right;
				sz[right] += sz[left];
			} else {
				id[right] = left;
				sz[left] += sz[right];
			}
			cnt -= 1;
		}
	}
		
	public boolean validTree (int n, int[][] edges) {
		if (edges.length != n - 1) return false;  // number of edge == number of vertices - 1
		UF uf = new UF(n);
		for (int[] e : edges) {
			uf.union(e[0], e[1]);
		}
		return uf.cnt == 1;  // && connected
	}
