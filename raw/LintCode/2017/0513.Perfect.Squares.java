/*
 *  http://www.lintcode.com/en/problem/perfect-squares/
 *
 *  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 */


// dp
	public int numSquares (int n) {

		int m = 1;
		while (m * m <= n) m ++;
		m -= 1;
		
		int[][] M = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {  // for each factor
			for (int j = 1; j <= n; j++) {  // for each number
				
				if (i == 1) M[i][j] = j;
				else if (j < i * i) M[i][j] = M[i-1][j];
				else M[i][j] = Math.min(M[i-1][j], M[i][j - i * i] + 1);

			}
		}
		
		return M[m][n];
	}




//  dp
	public int numSquares (int n) {
		int[] A = new int[n + 1];
		Arrays.fill(A, Integer.MAX_VALUE);
		A[0] = 0;
		int p = 1;
		while (p * p <= n) {
			for (int i = p * p; i <= n; i++) {
				A[i] = Math.min(A[i], A[i - p * p] + 1);  // 12 = 4 + 4 + 4
			}
			p ++;
		}

		return A[n];
	}




//  relaxation
	public int numSquares (int n) {
		int[] A = new int[n + 1];
		Arrays.fill(A, Integer.MAX_VALUE);
		A[0] = 0;


		for (int i = 0; i <= n; i++) {
			for (int p = 1; i + p * p <= n; p++) {  // at each number, how can we reduce number that are larger
				A[i + p * p] = Math.min(A[i + p * p], A[i] + 1);
			}
		}

		return A[n];
	}

