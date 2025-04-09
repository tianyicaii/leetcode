/*
 *  http://www.lintcode.com/en/problem/longest-repeating-subsequence/
 *
 *  Given a string, find length of the longest repeating subsequence such that the two subsequence don’t have same string character at same position,
 *  i.e., any ith character in the two subsequences shouldn’t have the same index in the original string.
 */


	public int longestRepeatingSubsequence (String str) {

		int[][] M = new int[str.length() + 1][str.length() + 1];
		
		for (int i = 1; i <= str.length(); i ++ ) {
			for (int j = 1; j <= str.length(); j ++) {
				
				
				if (i != j && str.charAt(i-1) == str.charAt(j-1)) M[i][j] = M[i-1][j-1] + 1;
				else M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
				

			}
		}
		
		return M[str.length()][str.length()];
	}







// [WRONG] Cubic running time
	public int longestRepeatingSubsequence (String str) {
		if (str.length() < 2) return 0; 
		int[][] M = new int[str.length() + 1][str.length() + 1];
		
		for (int i = 2; i <= str.length(); i ++ ) {
			for (int j = 1; j < i; j ++) {
				
				
				M[i][j] = M[i - 1][Math.min(i - 2, j)];  // cannot worse than with one letter less
				for (int k = j - 1; k >= 0; k--) {  // [WRONG]: all of this cases is covered by previous iterations by looking at the last two characters.
					if (str.charAt(k) == str.charAt(i - 1)) {
						M[i][j] = Math.max(M[i][j], M[i - 1][k] + 1);
						break;
					}
				}
				

			}
		}
		
		return M[str.length()][str.length() - 1];
	}
