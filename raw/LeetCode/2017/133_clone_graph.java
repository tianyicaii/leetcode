

	Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>();
	public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
		if (node == null) return null;
		dfs(node);
		for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> e : m.entrySet()) {
			for (UndirectedGraphNode n : e.getKey().neighbors) {
				e.getValue().neighbors.add(m.get(n));
			}
		}
		return m.get(node);
	}
	void dfs (UndirectedGraphNode x) {
		if (m.containsKey(x)) return;
		m.put(x, new UndirectedGraphNode(x.label));
		for (UndirectedGraphNode n : x.neighbors)
			dfs(n);
	}


	public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
		if (node == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>();
		Queue<UndirectedGraphNode> bfs = new LinkedList<UndirectedGraphNode>();
		bfs.offer(node);
		while (!bfs.isEmpty()) {
			UndirectedGraphNode x = bfs.poll();
			if (!m.containsKey(x)) {
				m.put(x, new UndirectedGraphNode(x.label));
				for (UndirectedGraphNode n : x.neighbors) {
					bfs.offer(n);
				}
			}
		}
		for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> e : m.entrySet()) {
			for (UndirectedGraphNode n : e.getKey().neighbors) {
				e.getValue().neighbors.add(m.get(n));
			}
		}
		return m.get(node);
	}
