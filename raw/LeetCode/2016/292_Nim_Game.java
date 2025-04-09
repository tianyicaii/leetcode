// https://leetcode.com/problems/nim-game/


public class Solution {
	

	public boolean canWinNim (int n) {
		boolean[] dp = new boolean[4];
		for (int i = 0; i <= n; i++) {
			if      (i == 0) dp[i%4] = false;
			else if (i == 1) dp[i%4] = true;
			else if (i == 2) dp[i%4] = true;
			else             dp[i%4] = dp[(i-1)%4] == false ||
									   dp[(i-2)%4] == false ||
									   dp[(i-3)%4] == false;
		}
		
		return dp[n%4];
	}	


}

