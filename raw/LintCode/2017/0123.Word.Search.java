/*
 *  http://www.lintcode.com/en/problem/word-search/
 *
 *  Given a 2D board and a word, find if the word exists in the grid.
 *  The word can be constructed from letters of sequentially adjacent cell,
 *  where "adjacent" cells are those horizontally or vertically neighboring.
 *  The same letter cell may not be used more than once.
 */

	//  try all possible ways
	//  this is not traversal problem
	//  this cannot be solved by BFS.
	
	public boolean exist (char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, new boolean[board.length][board[0].length], word, 0, i, j)) return true;
			}
		}
		return false;
	}

	boolean inBound (char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	
	int[] di = {-1, 1, 0, 0};
	int[] dj = {0, 0, -1 ,1};
	
	boolean dfs (char[][] board, boolean[][] visited, String word, int p, int i, int j) {
		
		if (board[i][j] != word.charAt(p)) return false;
		if (p == word.length() - 1) return true;  // matched all

		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + di[k];
			int y = j + dj[k];
			
			if (inBound(board, x, y) && !visited[x][y]) {  // no overlap with current path
				if (dfs(board, visited, word, p + 1, x, y)) return true;
			}
		}
		visited[i][j] = false;  //  remove footprint, enable next probe in different direction
		return false;	
	}
