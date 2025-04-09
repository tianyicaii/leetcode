/*

http://www.lintcode.com/en/problem/distinct-subsequences/

Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

*/

	public int numDistinct (String S, String T) {
		if (T.length() > S.length()) return 0;
		
		int[][] M = new int[T.length() + 1][S.length() + 1]; 
		
		for (int i = 0; i <= T.length(); i++) {
			for (int j = i; j <= S.length(); j++) {
				
				
				if (i == 0) M[i][j] = 1;  // empty string matches
				// else if (i == 1) M[i][j] = (S.charAt(0) == T.charAt(0)) ? 1 : 0;
				else {
					char t = T.charAt(i-1);
					char s = S.charAt(j-1);
					if (t == s) {
						M[i][j] = M[i][j-1] + M[i-1][j-1];
					} else {
						M[i][j] = M[i][j-1];
					}
				}
				
				
				
			}
		}
		
		
		return M[T.length()][S.length()];
	}	
