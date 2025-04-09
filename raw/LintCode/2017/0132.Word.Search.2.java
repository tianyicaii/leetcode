/*
 *  http://www.lintcode.com/en/problem/word-search-ii/
 *
 *  Given a matrix of lower alphabets and a dictionary.
 *  Find all words in the dictionary that can be found in the matrix.
 *  A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 
 */


	private class TrieNode {
		Map<Character, TrieNode> links = new HashMap<>();
		boolean eof = false;
	}
	
	TrieNode root = new TrieNode();
	
	void add (String s) {
		TrieNode curr = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
			curr = curr.links.get(c);
		}
		curr.eof = true;
	}




	int[] di = {-1, 1, 0, 0};
	int[] dj = {0, 0, -1, 1};
	
	boolean inBound (char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	



	void dfs (Set<String> ans, char[][] board, int i, int j, boolean[][] visited, StringBuilder path, TrieNode curr) {

		visited[i][j] = true;
		path.append(board[i][j]);
		if (curr.eof) ans.add(path.toString());
		
		for (int k = 0; k < 4; k++) {
			int x = i + di[k];
			int y = j + dj[k];
			if (inBound(board, x, y) && !visited[x][y]) {
				char c = board[x][y];
				if (curr.links.containsKey(c))
					dfs(ans, board, x, y, visited, path, curr.links.get(c));
			}
		}

		visited[i][j] = false;
		path.delete(path.length() - 1, path.length());
	}
	


	
	public List<String> wordSearchII (char[][] board, List<String> words) {

		Set<String> ans = new HashSet<>();
		for (String w : words) add(w);
		if (root.eof) ans.add("");
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (root.links.containsKey(c))
					dfs(ans, board, i, j, new boolean[board.length][board[0].length], new StringBuilder(), root.links.get(c));
			}
		}
		return new ArrayList<>(ans);
	}
