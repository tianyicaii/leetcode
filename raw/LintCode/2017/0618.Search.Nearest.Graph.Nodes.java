/*
 *  http://www.lintcode.com/en/problem/search-graph-nodes/
 *
 *  Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target,
 *  return NULL if you can't find.
 *  There is a mapping store the nodes' values in the given parameters.
 */


	// find the node with value equal target, that is *nearest* to the given node 
	public UndirectedGraphNode searchNode (ArrayList<UndirectedGraphNode> graph,
											Map<UndirectedGraphNode, Integer> values,
											UndirectedGraphNode node, int target) {

		Set<UndirectedGraphNode> visited = new HashSet<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(node);
		visited.add(node);

		while (!q.isEmpty()) {
			UndirectedGraphNode x = q.poll();
			if (values.get(x) == target) return x;
			for (UndirectedGraphNode e : x.neighbors) {
				if (visited.contains(e)) continue;
				else {
					visited.add(e);
					q.offer(e);
				}
			}
		}
		throw new RuntimeException("no found");
	}
