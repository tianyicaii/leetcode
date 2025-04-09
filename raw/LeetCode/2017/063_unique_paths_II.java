
	public int uniquePathsWithObstacles (int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] mem = new int[m][n];
		
		mem[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
		for (int i = m - 2; i >= 0; i--) {
			mem[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : mem[i + 1][n - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			mem[m - 1][j] = obstacleGrid[m - 1][j] == 1 ? 0 : mem[m - 1][j + 1];
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				mem[i][j] = obstacleGrid[i][j] == 1 ? 0 : mem[i + 1][j] + mem[i][j + 1];
			}
		}
		return mem[0][0];
	}
