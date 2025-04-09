// https://leetcode.com/problems/regular-expression-matching/


public class Solution {


	public boolean isMatch (String s, String p) {
		
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				
				if (i == 0 && j == 0) dp[i][j] = true;  // both empty
				else if (j == 0) dp[i][j] = false;  // string left over without match
				else if (i == 0) {
					if (p.charAt(j-1) == '*') dp[i][j] = dp[i][j-2];  // skip this '*'
					else                      dp[i][j] = false;  // non-'*' cannot be matched
				}
				
				else if (p.charAt(j-1) == '*') {  // either skip this '*', or expand it once more
					dp[i][j] = dp[i][j-2] ||
							   dp[i-1][j]   && match(s.charAt(i-1), p.charAt(j-2));
				}
				else {
					dp[i][j] = dp[i-1][j-1] && match(s.charAt(i-1), p.charAt(j-1));
				}
			}
		}
		
		return dp[m][n];		
	}
	
	private boolean match(char s, char p) {
		if (p == '.')  return true;
		return s == p;
	}


}

