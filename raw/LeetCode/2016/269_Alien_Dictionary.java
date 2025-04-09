// https://leetcode.com/problems/alien-dictionary/


public class Solution {
	

	public String alienOrder(String[] words) {

		Map<Character, Set<Character>> graph = buildGraph(words);
		Map<Character, Integer> inDegree = getInDegree(graph);
		List<Character> topOrder = getTopOrder (graph, inDegree);
		StringBuilder ans = new StringBuilder();  // empty of not exist
		for (char c : topOrder)
			ans.append(c);
		return ans.toString();
	}

	private Map<Character, Set<Character>> buildGraph (String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		// add vertices
		for (String s : words) {
			for (char c : s.toCharArray()) {
				if (!graph.containsKey(c))
					graph.put(c, new HashSet<>());
			}
		}
		// add edges
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				String s1 = words[i];
				String s2 = words[j];
				int k = 0;
				while (k < s1.length() && k < s2.length() && s1.charAt(k) == s2.charAt(k)) k++;
				if (k < s1.length() && k < s2.length())
					graph.get(s1.charAt(k)).add(s2.charAt(k));
			}
		}
		
		return graph;
	}
	
	private Map<Character, Integer> getInDegree(Map<Character, Set<Character>> graph) {
		Map<Character, Integer> inDegree = new HashMap<>();
		for (Map.Entry<Character, Set<Character>> e : graph.entrySet()) {
			inDegree.put(e.getKey(), 0);
		}
		for (Map.Entry<Character, Set<Character>> e : graph.entrySet()) {
			for (char c : e.getValue()) {
				inDegree.put(c, inDegree.get(c) + 1);
			}
		}
		return inDegree;
	}
	
	private List<Character> getTopOrder (Map<Character, Set<Character>> graph, Map<Character, Integer> inDegree) {
		List<Character> order = new ArrayList<>();
		Deque<Character> bfs = new ArrayDeque<>();
		for (Map.Entry<Character, Integer> e : inDegree.entrySet()) {
			if (e.getValue() == 0) bfs.offerLast(e.getKey());
		}
		while (!bfs.isEmpty()) {
			char v = bfs.pollFirst();
			order.add(v);
			for (char e : graph.get(v)) {
				inDegree.put(e, inDegree.get(e) - 1);
				if (inDegree.get(e) == 0) 
					bfs.offerLast(e);
			}
		}
		if (order.size() == graph.size()) return order;
		else                              return new ArrayList<>();  // does not exist
	}


}

