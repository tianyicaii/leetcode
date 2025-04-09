// https://leetcode.com/problems/wildcard-matching/


public class Solution {


	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				
				if (i == 0 && j == 0) dp[0][0] = true;  // empty matches empty
				else if (i == 0) {
					if (p.charAt(j-1) == '*') dp[i][j] = dp[i][j-1];  // match '*' to ""
					else                      dp[i][j] = false;
				}
				else if (j == 0)              dp[i][j] = false;  // string left over unmatched.
				else if (p.charAt(j-1) == '*') {
					dp[i][j] = dp[i][j-1] ||  // match '*' to ""
							   dp[i-1][j];    // use '*' once more
				}
				else {
					dp[i][j] = isMatch(s.charAt(i-1), p.charAt(j-1)) && dp[i-1][j-1];
				}
			}
		}
		
		return dp[m][n];
	}
	
	private boolean isMatch (char s, char p) {
		if (p == '?') return true;
		return s == p;
	}


}

