// https://leetcode.com/problems/minimum-height-trees/


public class Solution {
	

	public List<Integer> findMinHeightTrees (int n, int[][] edges) {
		List<Integer> ans = new ArrayList<>();
		if (n == 0) return ans;
		if (n == 1) { ans.add(0); return ans; }

		Map<Integer, Set<Integer>> G = buildGraph(n, edges);
		Map<Integer, Integer> D = getDegree(G);
		
		Deque<Integer> bfs = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		
		for (Map.Entry<Integer, Integer> v : D.entrySet()) {
			if (v.getValue() == 1) { 
				bfs.offerLast(v.getKey());
				visited.add(v.getKey());
			}
		}
		while (visited.size() < n) {
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {  // trim one level of leaves
				int v = bfs.pollFirst();
				for (int e : G.get(v)) {
					if (visited.contains(e)) continue;  // old leaf
					D.put(e, D.get(e) - 1);
					if (D.get(e) == 1) {
						bfs.offerLast(e);  // new leaf
						visited.add(e);
					}
				}
			}
		}
		ans.addAll(bfs);
		return ans;
	}
	
	private Map<Integer, Integer> getDegree (Map<Integer, Set<Integer>> G) {
		Map<Integer, Integer> D  = new HashMap<>();
		for (Map.Entry<Integer, Set<Integer>> v : G.entrySet()) {  // add vertices
			D.put(v.getKey(), 0);
		}
		for (Map.Entry<Integer, Set<Integer>> v : G.entrySet()) {
			for (Integer to : v.getValue()) {  // edges
				D.put(to, D.get(to) + 1);  // in-degree == out-degree
			}
		}
		return D;
	}
	
	private Map<Integer, Set<Integer>> buildGraph (int n, int[][] edges) {
		Map<Integer, Set<Integer>> G = new HashMap<>();
		for (int i = 0; i < n; i++)  // add vertices
			G.put(i, new HashSet<>());
		for (int[] e : edges) {  // add edges
			int from = e[0];
			int to   = e[1];
			G.get(from).add(to);
			G.get(to).add(from);
		}
		return G;
	}


}

