// https://leetcode.com/problems/add-and-search-word-data-structure-design/


public class Solution {


	// not precise lookup
	

	public class WordDictionary {
		
		private class TrieNode {
			Map<Character, TrieNode> links;
			boolean isWord;
			public TrieNode () {
				links = new HashMap<>();
			}
		}
		
		TrieNode root;
		int min = Integer.MAX_VALUE;  // for leetcode
		int max = Integer.MIN_VALUE;
		
		public WordDictionary () {
			root = new TrieNode();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}
		
		public void addWord (String word) {
			
			int n = word.length();
			if (n > max) max = n;
			if (n < min) min = n;
			
			TrieNode curr = root;
			for (int i = 0; i < n; i++) {
				if (!curr.links.containsKey(word.charAt(i)))
					curr.links.put(word.charAt(i), new TrieNode());
				curr = curr.links.get(word.charAt(i));
			}
			curr.isWord = true;
		}
		
		public boolean search (String word) {
			int n = word.length();
			if (n > max || n < min) return false;
			return helper(word, 0, root);
		}
		private boolean helper (String word, int index, TrieNode curr) {
			if (index == word.length()) {
				return curr.isWord;
			}
			char c = word.charAt(index);
			if (c == '.') {
				for (Map.Entry<Character, TrieNode> e : curr.links.entrySet()) {
					if (helper(word, index + 1, e.getValue())) return true;
				}
				return false;
			}
			else {
				if (!curr.links.containsKey(c)) return false;
				return helper(word, index + 1, curr.links.get(c));
			}
		}
	}


}

