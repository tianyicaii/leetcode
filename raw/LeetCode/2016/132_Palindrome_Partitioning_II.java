// https://leetcode.com/problems/palindrome-partitioning-ii/


public class Solution {
	

	public int minCut (String s) {
		int n = s.length();
		if (n == 0) return 0;  // special case zero palindrome, zero cut
		
		// is s[j...i] palindrome?
		boolean[][] isPar = new boolean[n][n];  // start index, end index
		for (int l = 1; l <= n; l++) {  // length
			for (int i = 0; i + l <= n; i++) {
				if (l == 1) isPar[i][i + l - 1] = true;
				else if (l == 2) isPar[i][i + l - 1] = s.charAt(i) == s.charAt(i + l - 1);
				else isPar[i][i + l - 1] = s.charAt(i) == s.charAt(i + l - 1) && isPar[i + 1][i + l - 1 - 1];
			}
		}
		
		int[] dp = new int[n + 1];  // for substring of length i, how many palindrome
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i <= n; i++) {
			if (i == 0) dp[i] = 0;  // zero in front
			else {
				for (int j = 0; j < i; j++) {  // test s[j...i]
					if (isPar[j][i-1]) {
						dp[i] = Math.min(dp[i], 1 + dp[j]);
					}
				}
			}
		}
		
		return dp[n] - 1;
	}


}

