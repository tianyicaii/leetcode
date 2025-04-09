/*
 *  http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/
 *
 *  Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 */

	public int mountainSequence (int[] nums) {
		if (nums.length == 0) return -1;
		if (nums.length == 1) return nums[0];
		if (nums[0] > nums[1]) return nums[0];
		if (nums[nums.length - 1] > nums[nums.length - 2]) return nums[nums.length - 1];
		
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return nums[mid];
			else if (nums[mid] < nums[mid - 1]) right = mid;
			else left = mid;
		}
		
		throw new RuntimeException("invalid input");
	}
