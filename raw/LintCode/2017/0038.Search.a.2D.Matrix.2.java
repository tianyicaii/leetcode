/*
 *  http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/
 *
 *  Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 *  This matrix has the following properties:
 *      Integers in each row are sorted from left to right.
 *      Integers in each column are sorted from up to bottom.
 *      *No duplicate* integers in each row or column.
 */

	public int searchMatrix (int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		int count = 0;
		int r = matrix.length - 1;  // start from bottom left
		int c = 0;
		while (r >= 0 && c < matrix[0].length) {
			int x = matrix[r][c];
			if (x == target) {
				count += 1;
				r--;
				c++;  // no duplicate on each row and column, move up right
			}
			else if (x < target) c++;
			else r--;
		}
		return count;
	}

