// https://leetcode.com/problems/scramble-string/


public class Solution {
	

	public boolean isScramble (String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.equals(s2)) return true;  // catch "" vs ""
		int n = s1.length();
		boolean[][][] dp = new boolean[n + 1][n][n];  // length of substring, start of s1, start of s2
		
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i + l <= n; i++) {
				for (int j = 0; j + l <= n; j++) {
					
					if (l == 1) {
						if (s1.charAt(i) == s2.charAt(j)) dp[l][i][j] = true;
						else                              dp[l][i][j] = false;
					}
					
					else {
						for (int k = 1; k < l && dp[l][i][j] == false; k++) {  // split at k, && **haven't succeeded yet.**
							dp[l][i][j] = (dp[k][i][j] && dp[l-k][i+k][j+k]) || 
										  (dp[k][i][j + l - k] && dp[l-k][i+k][j]);
						}
						
					}
					
				}
			}
		}
		
		
		return dp[n][0][0];
	}


}

