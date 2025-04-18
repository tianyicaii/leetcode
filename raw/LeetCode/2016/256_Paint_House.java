// https://leetcode.com/problems/paint-house/


public class Solution {


	public int minCost(int[][] costs) {

		if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
		int n = costs.length;
		int[][] dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {

				if (i == 0) dp[i][j] = costs[i][j];
				else        dp[i][j] = costs[i][j] + Math.min(dp[i-1][(j + 1) % 3], dp[i-1][(j + 2) % 3]);

			}
		}

		return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}


}

