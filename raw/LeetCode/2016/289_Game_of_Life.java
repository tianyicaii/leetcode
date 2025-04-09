// https://leetcode.com/problems/game-of-life/


public class Solution {
	

	public void gameOfLife (int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) return;  // nothing


		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {


				int lives = getNumOfLiveNeighbors(board, i, j);
				

				if (board[i][j] == 1) {
					if (lives < 2 || lives > 3) board[i][j] = 1;
					else                        board[i][j] = 3;
				}
				else {
					if (lives == 3) board[i][j] = 2;
					else            board[i][j] = 0;
				}
			}
		}


		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] >>= 1;
			}
		}
	}


	private int getNumOfLiveNeighbors (int[][] board, int r, int c) {
		int ans = 0;
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j ++) {
				if (i >= 0 && i < board.length && 
					j >= 0 && j < board[0].length && 
					(i != r || c != j) && 
					board[i][j] % 2 == 1)
					ans += 1;
			}
		}
		return ans;
	}
}

