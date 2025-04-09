/*
 *  http://www.lintcode.com/en/problem/two-sum-closest-to-target/
 *
 *  Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 *  Return the difference between the sum of the two integers and the target.
 */

	public int twoSumClosest (int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		Integer gap = null;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) return 0;
			else {
				gap = gap == null ? Math.abs(sum - target) : Math.min(gap , Math.abs(sum - target));
				if (sum > target) -- right;
				else ++ left;
			}
		}
		return gap;
	}
