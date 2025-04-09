// https://leetcode.com/problems/word-search-ii/


public class Solution {


	private class TrieNode {
		Map<Character, TrieNode> links;
		boolean isWord;
		public TrieNode () {
			links = new HashMap<>();
		}
	}
	
	private TrieNode buildTrie (String[] words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode curr = root;
			for (int i = 0; i < s.length(); i++) {
				if (!curr.links.containsKey(s.charAt(i)))
					curr.links.put(s.charAt(i), new TrieNode());
				curr = curr.links.get(s.charAt(i));
			}
			curr.isWord = true;
		}
		return root;
	}
	
	public List<String> findWords (char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0) return ans;  // nothing exists
		
		TrieNode root = buildTrie(words);
		boolean[][] onPath = new boolean[board.length][board[0].length];
		StringBuilder path = new StringBuilder();
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				if (root.links.containsKey(board[i][j]))
					dfs(ans, path, seen, board, onPath, i, j, root.links.get(board[i][j]));
		}
		return ans;
	}
	
	private final int[] dirs = {0, -1, 0, 1, 0};
	
	public void dfs (List<String> ans, StringBuilder path, Set<String> seen, char[][] board, boolean[][] onPath, int r, int c, TrieNode curr) {
		
		
		path.append(board[r][c]);
		onPath[r][c] = true;
		
		if (curr.isWord) {
			String word = path.toString();
			if (!seen.contains(word)) {  // avoid duplicates
				ans.add(word);
				seen.add(word);
			}
		}
						
		for (int k = 0; k < 4; k++) {
			int i = r + dirs[k];
			int j = c + dirs[k + 1];
			if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && 
					!onPath[i][j] && curr.links.containsKey(board[i][j]))
				dfs (ans, path, seen, board, onPath, i, j, curr.links.get(board[i][j]));
		}
		
		path.deleteCharAt(path.length() - 1);
		onPath[r][c] = false;
	}
	

}

