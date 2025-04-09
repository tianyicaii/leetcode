/*
 *  http://www.lintcode.com/en/problem/connected-component-in-undirected-graph/
 *
 *  Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *  (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths,
 *  and which is connected to no additional vertices in the supergraph.)
 */


	public List<List<Integer>> connectedSet (List<UndirectedGraphNode> nodes) {
		List<List<Integer>> subsets = new ArrayList<>();
		Set<UndirectedGraphNode> visited = new HashSet<>();
		
		for (UndirectedGraphNode x : nodes) {
			if (!visited.contains(x)) {
				visited.add(x);
				Set<UndirectedGraphNode> component = new HashSet<>();
				// bfs(x, visited, component);
				dfs(x, visited, component);
				addToResult(subsets, component);
			}
		}
		return subsets;
	}
	
	void addToResult (List<List<Integer>> subsets, Set<UndirectedGraphNode> component) {
		List<Integer> subset = new ArrayList<>();
		for (UndirectedGraphNode node : component) subset.add(node.label);
		Collections.sort(subset);  // needs to be ordered.
		subsets.add(subset);
	}
	
	void dfs (UndirectedGraphNode x, Set<UndirectedGraphNode> visited, Set<UndirectedGraphNode> component) {
		component.add(x);
		for (UndirectedGraphNode e : x.neighbors) {
			if (!visited.contains(e)) {
				visited.add(e);
				dfs(e, visited, component);
			}
		}
	}
	
	void bfs (UndirectedGraphNode start, Set<UndirectedGraphNode> visited, Set<UndirectedGraphNode> component) {
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			UndirectedGraphNode x = q.poll();
			component.add(x);
			for (UndirectedGraphNode e : x.neighbors) {
				if (!visited.contains(e)) {
					visited.add(e);
					q.offer(e);
				}
			}
		}
	}




// UF
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
		int find (int x) {
			while (id[x] != x) {
				id[x] = id[id[x]];
				x = id[x];
			}
			return x;
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
	
	public List<List<Integer>> connectedSet (List<UndirectedGraphNode> nodes) {
		List<List<Integer>> subsets = new ArrayList<>();
		Map<Integer, UndirectedGraphNode> indexToNode = new HashMap<>();
		Map<UndirectedGraphNode, Integer> nodeToIndex = new HashMap<>();
		int index = 0;
		for (UndirectedGraphNode x : nodes) {
			indexToNode.put(index, x);
			nodeToIndex.put(x, index);
			index += 1;
		}
		
		UF uf = new UF(nodes.size());
		for (UndirectedGraphNode x : nodes) {
			for (UndirectedGraphNode e : x.neighbors) {
				uf.union(nodeToIndex.get(x), nodeToIndex.get(e));
			}
		}
		
		Map<Integer, Set<Integer>> groups = new HashMap<>();  // components, represented by find(i).
		
		for (int i = 0; i < uf.id.length; i++) {
			if (!groups.containsKey(uf.find(i))) groups.put(uf.find(i), new HashSet<>());
			groups.get(uf.find(i)).add(i);
		}
		
		for (Map.Entry<Integer, Set<Integer>> e : groups.entrySet()) {
			List<Integer> s = new ArrayList<>();
			for (int i : e.getValue())
				s.add(indexToNode.get(i).label);
			subsets.add(s);
			Collections.sort(s);
		} 
		return subsets;
	}
