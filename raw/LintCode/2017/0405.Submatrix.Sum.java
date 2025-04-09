/*

http://www.lintcode.com/en/problem/submatrix-sum/

Given an integer matrix, find a submatrix where the sum of numbers is zero.
Your code should return the coordinate of the left-up and right-down number.

*/


	public int[][] submatrixSum (int[][] matrix) {
		int[][] ans = new int[2][2];  // two points, each has two coordinates
		if (matrix.length == 0 || matrix[0].length == 0) return new int[][] {};

		// prefix sum
		int[][] partialSums = new int[matrix.length + 1][matrix[0].length + 1];  // find sum of each rectangle [0][0] to [i-1][j-1]
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				partialSums[i][j] = partialSums[i][j-1] + partialSums[i-1][j] - partialSums[i-1][j-1] + matrix[i-1][j-1];
			}
		}
		
		// iterate all rectangles
		for (int width = 1; width <= matrix.length; width++) {  //  vertical length
			for (int top = 0; top + width <= matrix.length; top++) {  // index of top edge
				

				Map<Integer, Integer> left = new HashMap<>();  //  same as 1D for certain vertical length, (cut a horizontal band)
				
				
				for (int length = 0; length <= matrix[0].length; length++) {  // horizontal length
					if (length == 0) left.put(0, 0);
					else {
						int sum = partialSums[top + width][length] - partialSums[top][length];  // bottom right point - up right point
						if (left.containsKey(sum)) {
							ans[0][0] = top;
							ans[0][1] = left.get(sum);
							ans[1][0] = top + width - 1;
							ans[1][1] = length - 1;
							return ans;
						} else {
							left.put(sum, length);
						}
					}
				}
				
				
				
			}
		}
		
		return new int[][] {};
	}
