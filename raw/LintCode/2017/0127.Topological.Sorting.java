/*
 *  http://www.lintcode.com/en/problem/topological-sorting/
 *
 *  Given an directed graph, a topological order of the graph nodes is defined as follow:
 *  For each directed edge A -> B in graph, A must before B in the order list.
 *  The first node in the order can be any node in the graph with no nodes direct to it.
 *  Find any topological order for the given graph.
 */

	public ArrayList<DirectedGraphNode> topSort (ArrayList<DirectedGraphNode> graph) {
		Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();
		for (DirectedGraphNode x : graph) {
			inDegree.put(x, 0);
		}
		for (DirectedGraphNode x : graph) {
			for (DirectedGraphNode e : x.neighbors) {
				inDegree.put(e, inDegree.get(e) + 1);
			}
		}
		
		ArrayList<DirectedGraphNode> q = new ArrayList<>();
		for (Map.Entry<DirectedGraphNode, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) q.add(e.getKey());
		}
		
		int i = 0;
		while (i < graph.size()) {
			DirectedGraphNode x = q.get(i++);
			for (DirectedGraphNode e : x.neighbors) {
				inDegree.put(e, inDegree.get(e) - 1);
				if (inDegree.get(e) == 0) q.add(e);
			}
		}
		
		return q;
	}
