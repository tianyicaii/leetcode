// https://leetcode.com/problems/integer-break/


public class Solution {


	public int integerBreak (int n) {
		int[] dp = new int[Math.max(n + 1, 4)];
		
		dp[2] = 1;
		dp[3] = 2;
		for (int i = 4; i <= n; i++) {
			for (int j = 2; j <= i - 2; j++) {
				dp[i] = Math.max(dp[i], j * (i - j));  // no break on sub-problem
				dp[i] = Math.max(dp[i], j * dp[i - j]);  // break on sub-problem
			}
		}
		return dp[n];
	}


}

