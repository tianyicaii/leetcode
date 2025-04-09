/*
 *  http://www.lintcode.com/en/problem/triangle/
 *
 *  Given a triangle, find the minimum path sum from *top to bottom*.
 *  Each step you may move to adjacent numbers on the row below.
 */

	public int minimumTotal (int[][] triangle) {
		
		int m = triangle.length;
		int n = triangle[m - 1].length;
		
		int[][] A = new int[m][n];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (i == n - 1) A[i][j] = triangle[i][j];
				else A[i][j] = triangle[i][j] + Math.min(A[i + 1][j], A[i + 1][j + 1]);
			}
		}
		
		return A[0][0];
	}
