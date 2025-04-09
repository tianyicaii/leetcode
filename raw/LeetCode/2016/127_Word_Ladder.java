// https://leetcode.com/problems/word-ladder/


public class Solution {
	

	public int ladderLength (String beginWord, String endWord, Set<String> wordList) {
		
		wordList.add(beginWord);
		wordList.add(endWord);
		
		Set<String> seen = new HashSet();  // mark visited
		seen.add(beginWord);
		Deque<String> bfs = new ArrayDeque<>();
		bfs.offerLast(beginWord);
		int depth = 0;
		
		while (!bfs.isEmpty()) {
			depth += 1;
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				String vertex = bfs.pollFirst();
				if (vertex.equals(endWord)) return depth;  // found
				List<String> edges = getNeighbors(vertex, wordList);
				for (String e : edges) {
					if (seen.contains(e)) continue;
					seen.add(e);
					bfs.offerLast(e);
				}
			}
		}
		return 0;  // not found
	}
	
	private List<String> getNeighbors (String word, Set<String> dict) {
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i < word.length(); i++) {
			char original = word.charAt(i);
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == original) continue;
				String nextWord = word.substring(0, i) + c + word.substring(i + 1);
				if (dict.contains(nextWord)) 
					ans.add(nextWord);
			}
		}
		return ans;
	}


}

