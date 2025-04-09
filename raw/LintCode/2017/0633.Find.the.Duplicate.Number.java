/*
 *  http://www.lintcode.com/en/problem/find-the-duplicate-number/
 *
 *  Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 *  prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *  Notice
 *      You must not modify the array (assume the array is read only).
 *      You must use only constant, O(1) extra space.
 *      Your runtime complexity should be less than O(n^2).
 *      There is *only one* duplicate number in the array, but it could be repeated more than once.
 */


// pigeon hole
// search in solution space

	public int findDuplicate (int[] nums) {
		
		int min = 1;
		int max = nums.length - 1;

		if (count(nums, max) > 1) return max;
		
		while (min < max - 1) {
			int mid = (min + max) / 2;
			if (countLess(nums, mid) > mid - 1) max = mid;
			else min = mid;
		}
		
		return min;
	}
	

	private int count (int[] nums, int x) {
		int ans = 0;
		for (int i : nums)
			if (i == x) ans += 1;
		return ans;
	}
	
	private int countLess (int[] nums, int x) {
		int ans = 0;
		for (int i : nums)
			if (i < x) ans += 1;
		return ans;
	}
