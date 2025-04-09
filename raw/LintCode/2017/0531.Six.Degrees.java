/*
 *  http://www.lintcode.com/en/problem/six-degrees/
 *
 *  Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world,
 *  so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.
 *  Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.
 */

// each edge is contained in both vertices' edge list.

	public int sixDegrees (List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
		Set<UndirectedGraphNode> seen = new HashSet<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(s);
		int degree = 0;
		while (!q.isEmpty()) {
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				UndirectedGraphNode x = q.poll();
				if (x.label == t.label) return degree;
				for (UndirectedGraphNode e : x.neighbors) {
					if (!seen.contains(e)) {
						seen.add(e);
						q.offer(e);
					}
				}
			}
			++ degree;
		}
		return -1;
	}


	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
		UndirectedGraphNode(int x) { label = x; }
	}
