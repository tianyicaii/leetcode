// https://leetcode.com/problems/paint-fence/


public class Solution {
	

	public int numWays (int n, int k) {		
		if (n == 0) return 0;  // for leetcode
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) dp[i] = k;
			else if (i == 1) dp[i] = k * k;
			else dp[i] = dp[i-2] * (k - 1) + dp[i-1] * (k - 1);
		}
		return dp[n-1];
	}	


}

