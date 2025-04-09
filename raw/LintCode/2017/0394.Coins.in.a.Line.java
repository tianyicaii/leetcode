/*
 *  http://www.lintcode.com/en/problem/coins-in-a-line/
 *
 *  There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left.
 *  The player who take the last coin wins. Could you please decide the first play will win or lose?
 */


	public boolean firstWillWin (int n) {

		boolean[] m = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0) m[i] = false;  // last coin was taken by the opponent.
			else if (i == 1) m[i] = true;
			else if (i == 2) m[i] = true;
			else m[i] = !m[i-1] || !m[i-2];  // other's lose is my win
		}
		return m[n];
	}	
