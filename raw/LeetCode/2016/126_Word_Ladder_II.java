// https://leetcode.com/problems/word-ladder-ii/


public class Solution {
	

	// TLE


	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		
		
		wordList.add(beginWord);
		wordList.add(endWord);
		
		
		Map<String, List<String>> graph = new HashMap<>();
		
	// find depth
		Set<String> seen = new HashSet();  // mark visited
		seen.add(beginWord);
		Deque<String> bfs = new ArrayDeque<>();
		bfs.offerLast(beginWord);
		int depth = 0;
		boolean found = false;
		
		while (!bfs.isEmpty() && !found) {
			depth += 1;
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				String vertex = bfs.pollFirst();
				if (vertex.equals(endWord)) {
					found = true;
					break;  // found depth
				}
				List<String> edges = getNeighbors(vertex, wordList, graph);
				for (String e : edges) {
					if (seen.contains(e)) continue;
					seen.add(e);
					bfs.offerLast(e);
				}
			}
		}
		if (!found) return new ArrayList<>();  // cannot reach
		
	// dfs find all paths
		List<List<String>> ans = new ArrayList<>();
		Set<String> onPath = new HashSet<>();
		List<String> path = new ArrayList<>();
		dfs(ans, path, onPath, beginWord, endWord, depth, wordList, graph);
		return ans;
	}

	private void dfs (List<List<String>> ans, List<String> path, Set<String> onPath, String vertex, String dest, int depth, Set<String> dict, Map<String, List<String>> graph) {
		
		path.add(vertex);
		onPath.add(vertex);
		
		if (vertex.equals(dest)) {  // found
			ans.add(new ArrayList<String>(path));
		}
		else if (path.size() == depth) {
			;  // not found
		}
		else {
			List<String> edges = getNeighbors(vertex, dict, graph);
			for (String e : edges) {
				if (onPath.contains(e)) continue;
				dfs(ans, path, onPath, e, dest, depth, dict, graph);
			}
		}
			
		onPath.remove(vertex);
		path.remove(path.size() - 1);
	}
	
	private List<String> getNeighbors (String word, Set<String> dict, Map<String, List<String>> graph) {
		if (graph.containsKey(word)) return graph.get(word);

		List<String> edges = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			char original = word.charAt(i);
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == original) continue;
				String nextWord = word.substring(0, i) + c + word.substring(i + 1);
				if (dict.contains(nextWord)) 
					edges.add(nextWord);
			}
		}

		graph.put(word, edges);
		return edges;
	}


}

