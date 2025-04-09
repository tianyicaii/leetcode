// https://leetcode.com/problems/maximal-rectangle/


public class Solution {
	

	public int maximalRectangle (char[][] matrix) {
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] L = new int[n];
		int[] R = new int[n];
		Arrays.fill(R, n);
		int[] H = new int[n];
		int max = 0;
		
		
		for (int i = 0; i < m; i++) {
			
			int left  = 0;
			int right = n; 
					
		// find H
			for (int j= 0; j < n; j++) {
				if (matrix[i][j] == '1')
					H[j] += 1;
				else
					H[j]  = 0;
			}
		// find L
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					L[j] = Math.max(left, L[j]);
				else {
					L[j] = 0;
					left = j + 1;
				}					
			}
		// find R
			for (int j = n-1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					R[j] = Math.min(right, R[j]);
				else {
					R[j] = n;
					right = j;
				}
			}
		// find area
			for (int j = 0; j < n; j++) {
				max = Math.max(max, (R[j] - L[j]) * H[j]);
			}
		}
		
		return max;
	}


}

