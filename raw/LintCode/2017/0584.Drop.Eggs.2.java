/*
 *  http://www.lintcode.com/en/problem/drop-eggs-ii/
 *
 *  There is a building of n floors. If an egg drops from the k th floor or above, it will break.
 *  If it's dropped from any floor below, it will not break.
 *  You're given m eggs, Find k while minimize the number of drops for the worst case.
 *  Return the number of drops in the worst case.
 */

	public int dropEggs2 (int m, int n) {
		int[][] M = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				M[i][j] = Integer.MAX_VALUE;
				

				if (i == 1) {
					M[i][j] = j;
				} else {
					for (int k = 1; k <= j; k++) {
						M[i][j] = Math.min(M[i][j], 1 + Math.max(M[i-1][k-1], M[i][j-k]));
					}
				}


			}			
		}

		return M[m][n];
	}
