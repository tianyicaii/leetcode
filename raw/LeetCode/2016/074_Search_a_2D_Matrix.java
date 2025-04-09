// https://leetcode.com/problems/search-a-2d-matrix/


public class Solution {
	

	public boolean searchMatrix(int[][] matrix, int target) {
		int left = 0;
		int right = matrix.length * matrix[0].length - 1;
		
		if (get(matrix, left) == target) return true;
		if (get(matrix, right) == target) return true;
		
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			int M = get(matrix, mid);
			if (M == target) return true;
			if (M >  target) right = mid;
			else             left  = mid;
		}
		return false;
	}	
	
	private int get (int[][] matrix, int index) {
		int n = matrix[0].length;
		return matrix[index / n][index % n];
	}


}

