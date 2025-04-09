
/*

http://www.lintcode.com/en/problem/sliding-window-matrix-maximum/#

Given an array of n * m matrix, and a moving matrix window (size k * k),
move the window from top left to botton right at each iteration,
find the maximum sum inside the window at each moving.
Return 0 if the answer does not exist.

*/

	public int maxSlidingMatrix (int[][] matrix, int k) {
		
		if (k > matrix.length || k > matrix[0].length) return 0;
		
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] PS = new int[m+1][n+1];
		
		for (int i = 1; i <= m; i++) {  // find prefix sum for sub-array of length i and j
			for (int j = 1; j <= n; j++) {
				PS[i][j] = matrix[i-1][j-1] + PS[i][j-1] + PS[i-1][j] - PS[i-1][j-1];
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for (int i = k; i <= m; i++) {
			for (int j = k; j <= n; j++) {
				
				int sum = PS[i][j] - PS[i-k][j] - PS[i][j-k] + PS[i-k][j-k];
				ans = Math.max(ans, sum);
				
			}
		}
		
		return ans;
	}	
