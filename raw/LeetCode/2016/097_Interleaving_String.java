// https://leetcode.com/problems/interleaving-string/


public class Solution {
	

	public boolean isInterleave (String s1, String s2, String s3) {
		
		int m = s1.length();
		int n = s2.length();
		if (s3.length() != m + n) return false;
		
		boolean[][] dp = new boolean[2][s2.length() + 1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				
				if (i == 0 && j == 0) dp[i%2][j] = true;
				else if 	 (i == 0) dp[i%2][j] = dp[i%2][j-1]   && s2.charAt(j-1) == s3.charAt(i+j-1);
				else if 	 (j == 0) dp[i%2][j] = dp[(i-1)%2][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
				else 				  dp[i%2][j] = dp[(i-1)%2][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ||
												   dp[i%2][j-1]   && s2.charAt(j-1) == s3.charAt(i+j-1);
			}
		}
		
		return dp[m%2][n];
	}


}

