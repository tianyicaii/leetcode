/*
 *  http://www.lintcode.com/en/problem/maximal-square/
 *
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 */

// for square, the area (2D problem) can be easily reduced to (1D) problem (side length)
// for rectangle, it is reduced to 3 1D problems: left, right, height


	public int maxSquare(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		int[][] m = new int[matrix.length][matrix[0].length];
		
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (i == 0) m[i][j] = matrix[i][j];
				else if (j == 0) m[i][j] = matrix[i][j];
				else if (matrix[i][j] == 1) m[i][j] = Math.min(Math.min(m[i-1][j], m[i][j-1]), m[i-1][j-1]) + 1;
				else m[i][j] = 0;
				
				max = Math.max(max, m[i][j] * m[i][j]);
			}
		}
		
		return max;
	}	

