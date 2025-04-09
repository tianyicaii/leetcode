/*
 *  http://www.lintcode.com/en/problem/unique-paths-ii/
 *
 *  Follow up for "Unique Paths":
 *  Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *  An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */


	public int uniquePathsWithObstacles (int[][] obstacleGrid) {
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (obstacleGrid[i][j] == 1) A[i][j] = 0;
				else if (i == 0 && j == 0) A[i][j] = 1;
				else if (i == 0) A[i][j] = A[i][j - 1];
				else if (j == 0) A[i][j] = A[i - 1][j];
				else A[i][j] = A[i - 1][j] + A[i][j - 1];

			}
		}
		
		return A[m-1][n-1];
	}

