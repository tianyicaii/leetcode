/*
 *  http://www.lintcode.com/en/problem/two-sum-input-array-is-sorted/
 *
 *  Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *  Please note that your returned answers (both index1 and index2) are not zero-based.
 */

	public int[] twoSum (int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) return new int[] {left + 1, right + 1};
			else if (sum < target) left += 1;
			else right -= 1;
		}
		throw new RuntimeException("no solution");
	}
