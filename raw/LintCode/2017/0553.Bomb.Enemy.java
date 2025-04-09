/*

http://www.lintcode.com/en/problem/bomb-enemy/

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point
until it hits the wall since the wall is too strong to be destroyed.
Notice: You can only put the bomb at an empty cell.

*/


	public int maxKilledEnemies (char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] up = new int[m+1][n+1];  // length of the sub-array
		int[][] left = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (grid[i-1][j-1] != 'W') {
					if (grid[i-1][j-1] == 'E') {
						up[i][j] = up[i-1][j] + 1;
						left[i][j] = left[i][j-1] + 1;
					} else {
						up[i][j] = up[i-1][j];
						left[i][j] = left[i][j-1];
					}
				}
			}
		}
		
		int[][] right = new int[m+1][n+1];
		int[][] down = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (grid[m-i][n-j] != 'W') {
					if (grid[m-i][n-j] == 'E') {
						down[i][j] = down[i-1][j] + 1;
						right[i][j] = right[i][j-1] + 1;
					} else {
						down[i][j] = down[i-1][j];
						right[i][j] = right[i][j-1];
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if (grid[i][j] == '0') {
					int u = up[i+1][j+1];
					int l = left[i+1][j+1];
					int r = right[m-i][n-j];
					int d = down[m-i][n-j];
					ans = Math.max(ans, u + l + r + d);
				}
			}
		}
		
		return ans;
		
	}
