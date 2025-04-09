/*
 *  http://www.lintcode.com/en/problem/minimum-path-sum/
 *
 *  Given a m x n grid filled with non-negative numbers,
 *  find a path *from top left to bottom right* which minimizes the sum of all numbers along its path.
 */

	public int minPathSum (int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] A = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {


				if (i == 0 && j == 0) A[i][j] = grid[i][j];
				else if (i == 0) A[i][j] = grid[i][j] + A[i][j - 1];
				else if (j == 0) A[i][j] = grid[i][j] + A[i - 1][j];
				else A[i][j] = grid[i][j] + Math.min(A[i - 1][j], A[i][j - 1]);
			

			}
		}
		return A[m-1][n-1];
	}
