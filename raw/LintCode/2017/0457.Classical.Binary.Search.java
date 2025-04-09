/*
 *  http://www.lintcode.com/en/problem/classical-binary-search/
 *
 *  Find any position of a target number in a sorted array. Return -1 if target does not exist.
 */

	public int findPosition (int[] nums, int target) {
		if (nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) return mid;
			else if (nums[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}
