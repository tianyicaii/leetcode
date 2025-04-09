/*

http://www.lintcode.com/en/problem/interleaving-string/

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

*/


	public boolean isInterleave (String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) return false;
		
		boolean[][] M = new boolean[s1.length() + 1][s2.length() + 1];
		
		
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				
				
				
				if (i == 0 && j == 0) M[i][j] = true;
				else if (i == 0 && j != 0) M[i][j] = s2.charAt(j-1) == s3.charAt(j-1);
				else if (i != 0 && j == 0) M[i][j] = s1.charAt(i-1) == s3.charAt(i-1);
				else {
					char c1 = s1.charAt(i-1);
					char c2 = s2.charAt(j-1);
					char c3 = s3.charAt(i + j - 1);
					
					
					if (c1 != c3 && c2 != c3) M[i][j] = false;
					else if (c1 == c3 && c2 != c3) M[i][j] = M[i-1][j];
					else if (c1 != c3 && c2 == c3) M[i][j] = M[i][j-1];
					else // c1 == c3 && c2 == c3
						M[i][j] = M[i-1][j] || M[i][j-1];
				}
			}
		}
		
		
		return M[s1.length()][s2.length()];
	}	
