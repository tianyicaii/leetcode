// https://leetcode.com/problems/distinct-subsequences/


public class Solution {
	

	public int numDistinct (String s, String t) {
		int m = t.length();  // needle
		int n = s.length();  // haystack
		int[][] dp = new int[2][n + 1];
		
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 && j == 0) dp[i % 2][j] = 1;
				else if (i == 0)      dp[i % 2][j] = 1;
				else if (j == 0)      dp[i % 2][j] = 0;
				else {
					if (t.charAt(i-1) == s.charAt(j-1)) dp[i % 2][j] = dp[i % 2][j-1] + dp[(i-1) % 2][j-1];  // either match or not
					else                                dp[i % 2][j] = dp[i % 2][j-1];  // cannot match
				}
			}
		}
		
		return dp[m % 2][n];
	}


}

