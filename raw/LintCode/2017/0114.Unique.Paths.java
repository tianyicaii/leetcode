/*
 *  http://www.lintcode.com/en/problem/unique-paths/
 *
 *  A robot is located at the top-left corner of a m x n grid.
 *  The robot can only move either down or right at any point in time.
 *  The robot is trying to reach the bottom-right corner of the grid.
 *  How many possible unique paths are there?
 */

	public int uniquePaths (int m, int n) {
		
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) A[i][j] = 1;
				else if (i == 0) A[i][j] = A[i][j-1];
				else if (j == 0) A[i][j] = A[i-1][j];
				else A[i][j] = A[i - 1][j] + A[i][j - 1];
			}
		}
		
		return A[m-1][n-1];
	}
