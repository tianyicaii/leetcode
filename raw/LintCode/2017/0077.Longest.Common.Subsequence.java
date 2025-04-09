/*
 *  http://www.lintcode.com/en/problem/longest-common-subsequence/
 *
 *  Given two strings, find the longest common subsequence (LCS).
 *  Your code should return the length of LCS.
 */


	public int longestCommonSubsequence (String A, String B) {
		if (A.length() == 0 || B.length() == 0) return 0;
		
		
		int[][] m = new int[A.length()][B.length()];  // for each character in each string
		
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				
				if (i == 0 && j == 0) {
					if (A.charAt(i) == B.charAt(j)) m[i][j] = 1;
					else m[i][j] = 0;
				} else if (i == 0) {
					if (A.charAt(i) == B.charAt(j)) m[i][j] = 1;
					else m[i][j] = m[i][j-1];
				} else if (j == 0) {
					if (A.charAt(i) == B.charAt(j)) m[i][j] = 1;
					else m[i][j] = m[i-1][j];
				} else {
					if (A.charAt(i) == B.charAt(j)) m[i][j] = 1 + m[i-1][j-1];  // if this pair match, then match this pair
					else m[i][j] = Math.max(m[i-1][j], m[i][j-1]);  // otherwise, two paths to try
				}
			}
		}
		
		return m[A.length() - 1][B.length() - 1];
	}	

