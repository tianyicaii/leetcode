// https://leetcode.com/problems/coin-change/


public class Solution {


	public int coinChange (int[] coins, int amount) {
		if (amount <  0) return -1;

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		Arrays.sort(coins);

		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length && coins[j] <= i; j++) {
				if (dp[i - coins[j]] != -1) {
					if (dp[i] == -1) dp[i] = dp[i - coins[j]] + 1;
					else             dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				} 
			}
		}

		return dp[amount];
	}


}

