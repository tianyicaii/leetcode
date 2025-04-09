/*
 *  http://www.lintcode.com/en/problem/maximal-square-ii/
 *
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest square which diagonal is all 1 and others is 0.
 */


// count 1's on the main diagonal
// count 0's on vertical and horizontal edges

	public int maxSquare2 (int[][] matrix) {
		
		
		
		int[][] h = new int[matrix.length][matrix[0].length];
		int[][] v = new int[matrix.length][matrix[0].length];
		int[][] d = new int[matrix.length][matrix[0].length];
		
		int max = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				
				if (i == 0) {
					if (j == 0) {
						if (matrix[i][j] == 0) {
							h[i][j] = 1;
							v[i][j] = 1;
						} else {
							d[i][j] = 1;
						}
					} else {
						if (matrix[i][j] == 0) {
							h[i][j] = 1 + h[i][j-1];
							v[i][j] = 1;
						} else {
							d[i][j] = 1;
						}
					}
				} else {
					if (j == 0) {
						if (matrix[i][j] == 0) {
							h[i][j] = 1;
							v[i][j] = 1 + v[i-1][j];
						} else {
							d[i][j] = 1;
						}
					} else {
						if (matrix[i][j] == 0) {
							h[i][j] = 1 + h[i][j-1];
							v[i][j] = 1 + v[i-1][j];
						} else {
							d[i][j] = 1 + Math.min(d[i-1][j-1], Math.min(h[i][j-1], v[i-1][j]));
						}
					}
				}
				
				
				max = Math.max(d[i][j], max);
			}
		}
		

		return max * max;
	}	
