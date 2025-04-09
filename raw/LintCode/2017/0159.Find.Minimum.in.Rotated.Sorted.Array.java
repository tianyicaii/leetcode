/*
 *  http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
 *
 *  Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *  You may assume *no duplicate* exists in the array.
 *  (i.e., [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2]).
 *  Find the minimum element.
 */

	public int findMin (int[] nums) {
		if (nums.length == 0) return -1;
		if (nums.length == 1) return nums[0];
		if (nums[0] < nums[nums.length - 1]) return nums[0];  // special case, no rotation
		
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[left]) left = mid;  // mid is on left interval
			else right = mid;  // nums[mid] < nums[right], mid is on right interval
		}
		return nums[right];  // min is on right interval
	}
