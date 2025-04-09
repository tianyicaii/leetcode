// https://leetcode.com/problems/guess-number-higher-or-lower-ii/


public class Solution {


	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n];  // length, starting index
		for (int len = 1; len <= n; len ++) {
			for (int i = 0; i + len <= n; i++) {
				if (len == 1) dp[len][i] = 0;  // only one number to guess. no penalty
				else {
					dp[len][i] = Integer.MAX_VALUE;
					for (int k = i; k < i + len; k++) {
						if (k == i) {
							dp[len][i] = Math.min(dp[len][i], dp[len - 1][i + 1] + (k + 1));  // one based
						}
						else if (k == i + len - 1) {
							dp[len][i] = Math.min(dp[len][i], dp[len - 1][i] + (k + 1));
						}
						else {
							dp[len][i] = Math.min(dp[len][i], Math.max(dp[k - i][i], dp[len - (k - i + 1)][k + 1]) + (k + 1));
						}
					}
				}
			}
		}
		return dp[n][0];
	}	


}

