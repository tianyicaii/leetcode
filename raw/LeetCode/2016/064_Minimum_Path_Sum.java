// https://leetcode.com/problems/minimum-path-sum/


public class Solution {
	

	public int minPathSum (int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[2][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) dp[i % 2][j] = grid[i][j];
				else if (i == 0)      dp[i % 2][j] = dp[i % 2][j - 1] + grid[i][j];
				else if (j == 0)      dp[i % 2][j] = dp[(i-1) % 2][j] + grid[i][j];
				else                  dp[i % 2][j] = Math.min(dp[i % 2][j-1], dp[(i-1) % 2][j]) + grid[i][j];
			}
		}
		
		return dp[(m-1) % 2][n-1];
		
	}


}


