/*
 *  http://www.lintcode.com/en/problem/last-position-of-target/
 *
 *  Find the last position of a target number in a *sorted* array.
 *  Return -1 if target does not exist.
 */

	public int lastPosition (int[] nums, int target) {
		if (nums.length == 0) return -1;
		if (nums[0] > target) return -1;  // cannot return 0 if equal, it might not be the last occurrence
		if (nums[nums.length - 1] < target) return -1;
		if (nums[nums.length - 1] == target) return nums.length - 1;  // left != right, need to check nums[nums.length - 1] == target here.
		
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {  // invariant: nums[left] <= target && nums[right] > target
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) left = mid;
			else right = mid;
		}
		
		if (nums[left] == target) return left;
		else return -1;
	}
