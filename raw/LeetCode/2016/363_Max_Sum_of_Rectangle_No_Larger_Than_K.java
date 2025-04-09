// https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/


public class Solution {


	public int maxSumSubmatrix (int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = Integer.MIN_VALUE;  // assume solution exists.

		for (int i = 0; i < m; i++) {  // top
			int[] array = new int[n];
			for (int j = i; j < m; j++) {  // bottom
				for (int c = 0; c < n; c++) {
					array[c] += matrix[j][c];  // sum of col
				}
				int max = helper(array, k);
				ans = Math.max(ans, max);
			}
		}
		return ans;
	}	
	
	// in-accurate lookup
	private int helper (int[] array, int k) {
		int result = Integer.MIN_VALUE;
		TreeSet<Integer> seen = new TreeSet<>();
		seen.add(0);  // preSum exactly == k
		int preSum = 0;
		for (int a : array) {
			preSum += a;
			int diff = preSum - k;  // case 1: pos, case 2: neg
			Integer left = seen.ceiling(diff);
			if (left != null) {
				result = Math.max(result, preSum - left);
			}
			seen.add(preSum);
		}
		return result;
	}


}

