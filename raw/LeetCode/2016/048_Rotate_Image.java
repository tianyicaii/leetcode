// https://leetcode.com/problems/rotate-image/


public class Solution {


	/*
	 
	 	1 2   =>   4 2   =>  3 1
	 	3 4        3 1       4 2
	 	      =>   1 3   =>  3 1  
	               2 4       4 2
	 */
	
	public void rotate (int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) return;
		transpose(matrix);
		flipLR(matrix);
	}
	
	private void transpose (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}
	
	private void flipLR (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				swap(matrix, i, j, i, matrix[0].length - j - 1);
			}
		}
	}
	
	private void swap (int[][] matrix, int r1, int c1, int r2, int c2) {
		int tmp = matrix[r1][c1];
		matrix[r1][c1] = matrix[r2][c2];
		matrix[r2][c2] = tmp;
	}


}

