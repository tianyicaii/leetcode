/*
 *  http://www.lintcode.com/en/problem/two-sum-greater-than-target/
 *
 *  Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number.
 *  Please return the number of pairs.
 */

	public int twoSum2 (int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int ans = 0;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum <= target) {
				left ++;
			} else {  // sum > target
				ans += (right - left);
				right --;
			}

		}
		return ans;
	}
