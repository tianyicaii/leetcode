// https://leetcode.com/problems/clone-graph/


public class Solution {
	

	public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
		if (node == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> clone = new HashMap<>();
		// clone nodes, bfs
		Deque<UndirectedGraphNode> bfs = new ArrayDeque<>();
		bfs.offerLast(node);
		clone.put(node, new UndirectedGraphNode(node.label));
		
		while (!bfs.isEmpty()) {
			UndirectedGraphNode v = bfs.pollFirst();
			for (UndirectedGraphNode e : v.neighbors) {
				if (clone.containsKey(e)) continue;
				else {
					clone.put(e, new UndirectedGraphNode(e.label));
					bfs.offerLast(e);
				}
			}
		}
		
		for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> pair : clone.entrySet()) {
			UndirectedGraphNode original = pair.getKey();
			UndirectedGraphNode copy     = pair.getValue();
			for (UndirectedGraphNode e : original.neighbors) {
				copy.neighbors.add(clone.get(e));
			}
		}
		
		return clone.get(node);
	}


}

