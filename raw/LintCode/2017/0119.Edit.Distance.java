/*
 *  http://www.lintcode.com/en/problem/edit-distance/
 *
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *  You have the following 3 operations permitted on a word:
 *      Insert a character
 *      Delete a character
 *      Replace a character
 */


	public int minDistance (String word1, String word2) {


		if (word1.length() == 0) return word2.length();
		if (word2.length() == 0) return word1.length();
		

		int[][] m = new int[word1.length()][word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				

				if (i == 0 && j == 0) {
					if (word1.charAt(i) == word2.charAt(j)) m[i][j] = 0;
					else m[i][j] = 1;
				} else if (i == 0) {
					if (word1.charAt(i) == word2.charAt(j)) m[i][j] = j;
					else m[i][j] = Math.min(j, m[i][j-1]) + 1;
				} else if (j == 0) {
					if (word1.charAt(i) == word2.charAt(j)) m[i][j] = i;
					else m[i][j] = Math.min(i, m[i-1][j]) + 1;
				} else {
					if (word1.charAt(i) == word2.charAt(j)) m[i][j] = m[i-1][j-1];
					else m[i][j] = Math.min(m[i-1][j-1], Math.min(m[i-1][j], m[i][j-1])) + 1;
				}


			}
		}
		
		return m[word1.length() - 1][word2.length() - 1];
	}

