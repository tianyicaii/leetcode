/*
 *  http://www.lintcode.com/en/problem/search-a-2d-matrix/
 *
 *  Write an efficient algorithm that searches for a value in an m by n matrix.
 *  This matrix has the following properties:
 *      Integers in each row are sorted from left to right.
 *      The first integer of each row is greater than the last integer of the previous row.
 */

	public boolean searchMatrix (int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		int[] leftColumn = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++)
			leftColumn[i] = matrix[i][0];
		int rowIndex = lastPosition(leftColumn, target);
		if (rowIndex == -1) return false;
		int colIndex = lastPosition(matrix[rowIndex], target);
		return colIndex != -1 && matrix[rowIndex][colIndex] == target;
	}

	
	public int lastPosition (int[] nums, int target) {  // returns last element e such that e <= target
		if (nums.length == 0) return -1;
		if (nums[0] > target) return -1;
		if (nums[nums.length - 1] <= target) return nums.length - 1;
		
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {  // invariant: nums[left] <= target && nums[right] > target
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) left = mid;
			else right = mid;
		}
		
		return left;
	}
