// https://leetcode.com/problems/word-search/


public class Solution {
	

	private final int[] dirs = { 0, -1, 0, 1, 0 };

	public boolean exist (char[][] board, String word) {
		
		// assume not empty string, not empty board
		
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, visited, i, j, word, 0)) return true;
			}
		}
		return false;
	}
	
	private boolean dfs (char[][] board, boolean[][] visited, int r, int c, String word, int index) {
		
		if (board[r][c] != word.charAt(index)) return false;
		if (index == word.length() - 1) return true;
		
		visited[r][c] = true;  // on path
		for (int k = 0; k < 4; k++) {
			int i = r + dirs[k];
			int j = c + dirs[k + 1];
			if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j]) {
				if (dfs(board, visited, i, j, word, index + 1)) return true;
			}
		}
		visited[r][c] = false;  // remove from path
		return false;
	}


}

