// https://leetcode.com/problems/set-matrix-zeroes/


public class Solution {
	

	public void setZeroes (int[][] matrix) {
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		
		int m = matrix.length;
		int n = matrix[0].length;

		boolean setFirstRow = false;
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				setFirstRow = true;
				break;
			}
		}
		boolean setFirstCol = false;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				setFirstCol = true;
				break;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int j = 1; j < n; j++) {  // don't touch first col
			if (matrix[0][j] == 0) {
				setColZero(matrix, j);
			}
		}
		
		for (int i = 1; i < m; i++) {  // don't touch first row
			if (matrix[i][0] == 0) {
				setRowZero(matrix, i);
			}
		}
		
		if (setFirstRow) {
			setRowZero(matrix, 0);
		}
		if (setFirstCol) {
			setColZero(matrix, 0);
		}
	}
	
	
	private void setRowZero (int[][] matrix, int r) {
		for (int j = 0; j < matrix[0].length; j++) 
			matrix[r][j] = 0;
	}
	private void setColZero (int[][] matrix, int c) {
		for (int i = 0; i < matrix.length; i++)
			matrix[i][c] = 0;
	}
	

}

