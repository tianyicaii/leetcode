// https://leetcode.com/problems/design-tic-tac-toe/


public class TicTacToe {


	// int[][] board;
	int[] rows;
	int[] cols;
	int diagonal;
	int antidiagonal;
	int sz;


	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		sz = n;
		// board = new int[n][n];
		rows = new int[n];
		cols = new int[n];
		diagonal = 0;
		antidiagonal = 0;
	}
	
	/** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */

	public int move(int r, int c, int player) {
		if (player == 1) {
			rows[r] += 1;
			cols[c] += 1;
			if (r == c) {
				diagonal += 1;
			}
			if (r == sz-1-c) {
				antidiagonal += 1;
			}
			if (rows[r] == sz || cols[c] == sz || diagonal == sz || antidiagonal == sz)
				return 1;
		}
		else {  // player == 2
			rows[r] -= 1;
			cols[c] -= 1;
			if (r == c) {
				diagonal -= 1;
			}
			if (r == sz-1-c) {
				antidiagonal -= 1;
			}
			if (rows[r] == -sz || cols[c] == -sz || diagonal == -sz || antidiagonal == -sz)
				return 2;
		}
		return 0;
	}


}

