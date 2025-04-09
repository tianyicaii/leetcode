/*
 *  http://www.lintcode.com/en/problem/add-and-search-word/
 *
 *  Design a data structure that supports the following two operations: addWord(word) and search(word)
 *  search(word) can search a literal word or a regular expression string containing only letters a-z or '.'.
 *  A '.' means it can represent any one letter.
 */


	public class WordDictionary {
		
		private class TrieNode {
			Map<Character, TrieNode> chars = new HashMap<>();
			boolean eof = false;
		}
		
		TrieNode root = new TrieNode();
		
		public void addWord (String word) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!curr.chars.containsKey(c)) curr.chars.put(c, new TrieNode());
				curr = curr.chars.get(c);
			}
			curr.eof = true;
		}


		public boolean search(String pattern) {
			// return dfs(pattern, 0, root);
			return bfs(pattern);
		}

		boolean dfs (String pattern, int index, TrieNode curr) {
			if (index == pattern.length()) return curr.eof;  // matched all.
			if (pattern.charAt(index) == '.') {
				for (Map.Entry<Character, TrieNode> e : curr.chars.entrySet()) {
					if (dfs(pattern, index + 1, e.getValue())) return true;
				}
				return false;
			} else {
				if (!curr.chars.containsKey(pattern.charAt(index))) return false;
				return dfs(pattern, index + 1, curr.chars.get(pattern.charAt(index)));
			}
		}
		
		boolean bfs (String pattern) {
			
			Queue<TrieNode> q = new LinkedList<>();
			q.offer(root);
			int index = 0; // next character to find

			while (!q.isEmpty()) {

				int sz = q.size();
				for (int i = 0; i < sz; i++) {  //  sz == 1 || sz > 1
					TrieNode x = q.poll();
					
					if (index == pattern.length()) {  // matched all.
						if (x.eof) return true;
					} else {
						if (pattern.charAt(index) == '.') {
							for (Map.Entry<Character, TrieNode> e : x.chars.entrySet()) {
								q.offer(e.getValue());
							}
						} else {
							if (x.chars.containsKey(pattern.charAt(index))) {
								q.offer(x.chars.get(pattern.charAt(index)));
							}
						}
					}
				}
				index ++;
			}
			
			return false;
		}
	}
