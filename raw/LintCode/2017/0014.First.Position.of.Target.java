/*
 *  http://www.lintcode.com/en/problem/first-position-of-target/#
 *
 *  For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 *  If the target number does not exist in the array, return -1.
 */

	public int binarySearch(int[] nums, int target) {
		if (nums.length == 0) return -1;
		if (nums[0] > target) return -1;
		if (nums[0] == target) return 0;
		if (nums[nums.length - 1] < target) return -1;
		
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) right = mid;
			else left = mid;
		}
		if (nums[right] == target) return right;
		else return -1;
	}
