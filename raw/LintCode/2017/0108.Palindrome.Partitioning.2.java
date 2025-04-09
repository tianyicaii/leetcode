/*
 *  http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
 *
 *  Given a string s, cut s into some substrings such that every substring is a palindrome.
 *  Return the minimum cuts needed for a palindrome partitioning of s.
 */

	public int minCut (String s) {
		
		int[] m = new int[s.length() + 1];
		boolean[][] isPal = findPal(s);

		for (int i = 0; i <= s.length(); i++) m[i] = i;  // at most one character per cut
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= i-1; j++) {
				if (isPal[j][i-1]) m[i] = Math.min(m[i], 1 + m[j]);
			}
		}

		return m[s.length()] - 1;
	}


	private boolean[][] findPal (String s) {
		boolean[][] pal = new boolean[s.length()][s.length()];
		for (int c = 0; c < s.length(); c++) {  // if axis is one of the character
			int i = c;
			int j = c;
			while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				pal[i][j] = true;
				i--;
				j++;
			}
		}
		for (int c = 0; c < s.length(); c++) {  // if axis is between two characters
			int i = c;
			int j = c + 1;
			while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				pal[i][j] = true;
				i--;
				j++;
			}
		}
		return pal;
	}
