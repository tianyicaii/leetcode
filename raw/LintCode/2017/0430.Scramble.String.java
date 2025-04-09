
/*
	http://www.lintcode.com/en/problem/scramble-string/

	Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	Below is one possible representation of s1 = "great":

	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t

	To scramble the string, we may choose any non-leaf node and swap its two children.
	For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t

	We say that "rgeat" is a scrambled string of "great".
	Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".
	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/


	// sub-problem:
	// given arbitrary two substrings from s1 and s2 of same length, are they isScramble() ?
	
	
	public boolean isScramble (String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.length() == 0) return true;
		
		
		boolean[][][] m = new boolean[s1.length() + 1][s1.length()][s1.length()];
		
		
		for (int i = 1; i <= s1.length(); i++) {  //  length of each sub-string, eventually cover entire string of length s1.length()
			for (int j = 0; j + i <= s1.length(); j++) {  // starting point of each sub-string in string s1
				for (int k = 0; k + i <= s1.length(); k++) {  //  starting point of each sub-string in string s2
					
					// s1[j...j+1-1] and s2[k...k+i-1]: are they isScramble() ?
					
					if (i == 1) m[i][j][k] = s1.charAt(j) == s2.charAt(k);
					else {
						for (int l = 1; l < i && m[i][j][k] == false; l++) {  // try each cutting point with in length k			
							m[i][j][k] = m[l][j][k] && m[i - l][j + l][k + l] || m[l][j][k + i - l] && m[i - l][j + l][k];  // flip or not flip
						}
					}

					
				}
			}
		}
		
		return m[s1.length()][0][0];
	}
