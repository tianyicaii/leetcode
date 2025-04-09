/*
 *  http://www.lintcode.com/en/problem/clone-graph/
 *
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *  How we serialize an undirected graph:
 *      Nodes are labeled uniquely.
 *      We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *      As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *      The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *      First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *      Second node is labeled as 1. Connect node 1 to node 2.
 *      Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 *      Visually, the graph looks like the following:
 *             1
 *            / \
 *           /   \
 *          0 --- 2
 *               / \
 *               \_/
 */


// Given graph is connected.
// Or, we just copy its component.

	public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
		if (node == null) return null;
		List<UndirectedGraphNode> nodes = bfs(node);  // get all the nodes
		Map<UndirectedGraphNode, UndirectedGraphNode> clone = new HashMap<>();  // map given nodes to corresponding clones
		for (UndirectedGraphNode x : nodes) {
			clone.put(x, new UndirectedGraphNode(x.label));  // copy vertices
		}
		for (UndirectedGraphNode x : nodes) {
			for (UndirectedGraphNode e : x.neighbors) {
				clone.get(x).neighbors.add(clone.get(e));  // copy edges
			}
		}
		return clone.get(node);
	}

	public List<UndirectedGraphNode> bfs (UndirectedGraphNode start) {
		Set<UndirectedGraphNode> seen = new HashSet<>();
		List<UndirectedGraphNode> ans = new ArrayList<>();
		int index = 0;
		ans.add(start);
		seen.add(start);
		while (index != ans.size()) {
			UndirectedGraphNode x = ans.get(index);
			index ++;  //  mimic dequeue
			for (UndirectedGraphNode e : x.neighbors) {
				if (seen.contains(e)) continue;
				else {
					seen.add(e);  // avoid add this neighbor as someone else's neighbor later.
					ans.add(e);
				}
			}
		}
		return ans;
	}
