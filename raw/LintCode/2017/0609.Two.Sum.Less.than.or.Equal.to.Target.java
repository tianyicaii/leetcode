/*
 *  http://www.lintcode.com/en/problem/two-sum-less-than-or-equal-to-target/
 *
 *  Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number.
 *  Please return the number of pairs.
 */

	public int twoSum5 (int[] nums, int target) {
		Arrays.sort(nums);
		int ans = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum <= target) {
				ans += (right - left);
				left += 1;
			}
			else right -= 1;
		}
		return ans;
	}

