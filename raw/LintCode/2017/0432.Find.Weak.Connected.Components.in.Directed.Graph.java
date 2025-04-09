/*
 *  http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 *
 *  Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 *      Notice
 *      Sort the element in the set in increasing order
 */


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


	public List<List<Integer>> connectedSet2 (ArrayList<DirectedGraphNode> nodes) {
		List<List<Integer>> ans = new  ArrayList<>();
		UF uf = new UF(nodes.size());

		Map<Integer, DirectedGraphNode> indexToNode = new HashMap<>();
		Map<DirectedGraphNode, Integer> nodeToIndex = new HashMap<>();
		
		int index = 0;
		for (DirectedGraphNode x : nodes) {
			indexToNode.put(index, x);
			nodeToIndex.put(x, index);
			index += 1;
		}
		
		for (DirectedGraphNode x : nodes) {
			for (DirectedGraphNode e : x.neighbors) {
				uf.union(nodeToIndex.get(x), nodeToIndex.get(e));
			}
		}
		
		Map<Integer, Set<Integer>> groups = new HashMap<>();
		
		for (int i = 0; i < uf.id.length; i++) {
			int representative = uf.find(i);
			if (!groups.containsKey(representative)) groups.put(representative, new HashSet<>());
			groups.get(representative).add(i);
		}
		
		for (Map.Entry<Integer, Set<Integer>> e : groups.entrySet()) {
			List<Integer> subset = new ArrayList<>();
			for (int i : e.getValue())
				subset.add(indexToNode.get(i).label);
			Collections.sort(subset);
			ans.add(subset);
		} 
		return ans;
	}
