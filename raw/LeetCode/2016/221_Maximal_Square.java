// https://leetcode.com/problems/maximal-square/


public class Solution {


	public int maximalSquare (char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int max = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if      (i == 0) dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
				else if (j == 0) dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
				else {
					if (matrix[i][j] == '0') dp[i][j] = 0;
					else {
						int left = dp[i][j-1];
						int up = dp[i-1][j];
						int corner = dp[i-1][j-1];
						
						int L = Math.min(left, corner);
						int U = Math.min(up, corner);
						dp[i][j] = Math.min(L, U) + 1;
					}					
				}
				int side = dp[i][j];
				if (side * side > max) max = side * side;
			}
		}
		
		return max;
	}	


}

