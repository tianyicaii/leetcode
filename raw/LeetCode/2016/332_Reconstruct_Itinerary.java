// https://leetcode.com/problems/reconstruct-itinerary/


public class Solution {


	// assume Eulerian path exists, jsut mindlessly poll next edges
	
	public List<String> findItinerary (String[][] tickets) {
		List<String> ans = new LinkedList<>();
		
		// build graph
		Map<String, PriorityQueue<String>> G = new HashMap<>();
		for (String[] edge : tickets) 
			G.put(edge[0], new PriorityQueue<>());
		for (String[] edge : tickets)
			G.get(edge[0]).offer(edge[1]);
		

		return dfs(G, "JFK");
	}	
	
	private List<String> dfs (Map<String, PriorityQueue<String>> G, String from) {
		List<String> ans = new LinkedList<>();
		if (!G.containsKey(from)) {  // end point, going no where
			ans.add(from);
			return ans;
		}
		else {
			PriorityQueue<String> edges = G.get(from);
			while (!edges.isEmpty()) {
				String to = edges.poll();
				List<String> subpath = dfs(G, to);
				ans.addAll(0, subpath);
			}
			ans.add(0, from);
		}
		return ans;
	}


}

