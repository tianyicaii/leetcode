// https://leetcode.com/problems/sudoku-solver/


public class Solution {


	public void solveSudoku(char[][] board) {
		fill(board);
	}
	
	private boolean fill (char[][] board) {
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					boolean found = false;
					for (int k = 1; k <= 9 && !found; k++) {
						board[i][j] = (char)(k + '0');
						if (!isValidSudoku(board)) continue;
						found = fill(board);
					}
					if (found) return true;
					else {
						board[i][j] = '.';
						return false;
					}
				}
				
			}
		}
		return true;
	}

	public boolean isValidSudoku (char[][] board) {
		Set<Character> exist = new HashSet<>();
		
		// rows
		for (int i = 0; i < 9; i++) {
			exist.clear();
			for (int j = 0; j < 9; j++) {
				if (!isValid(exist, board, i, j)) return false;
			}
		}
		
		// cols
		for (int j = 0; j < 9; j++) {
			exist.clear();
			for (int i = 0; i < 9; i++) {
				if (!isValid(exist, board, i, j)) return false;
			}
		}
		
		// cells
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				exist.clear();
				
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (!isValid(exist, board, i*3 + r, j*3 + c)) return false;
					}	
				}
				
			}
		}
		
		return true;
	}
	
	private boolean isValid (Set<Character> exist, char[][] board, int i, int j) {
		if (board[i][j] != '.') {
			if (exist.contains(board[i][j])) return false;
		}
		exist.add(board[i][j]);
		return true;
	}


}

