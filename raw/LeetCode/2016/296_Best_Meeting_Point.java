// https://leetcode.com/problems/best-meeting-point/


public class Solution {
	

	public int minTotalDistance (int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int[] row = new int[grid[0].length];
		int[] col = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					row[j] += 1;
					col[i] += 1;
				}
			}
		}
		return helper(row) + helper(col);
	}
	
	private int helper (int[] A) {
		int cost = 0;
		int left = 0;
		int right = A.length - 1;
		int L = A[left];
		int R = A[right];
		while (left < right) {
			if (L > R) {
				cost += R;
				right -= 1;
				R += A[right];
			}
			else {
				cost += L;
				left += 1;
				L += A[left];
			}
		}
		return cost;
	}


}

