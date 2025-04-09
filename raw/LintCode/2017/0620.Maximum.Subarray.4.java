/*
 *  http://www.lintcode.com/en/problem/maximum-subarray-iv/
 *
 *  Given an integer arrays, find a contiguous subarray which has the largest sum and length should be greater or equal to given length k.
 *  Return the largest sum, return 0 if there are fewer than k elements in the array.
 */

// greedy
	public int maxSubarray4 (int[] nums, int k) {
		int[] prefix = new int[nums.length + 1];
		int min = 0;
		Integer max = null;
		for (int i = 1; i <= nums.length; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
			if (i == k) {
				max = prefix[i];
			}
			if (i > k) {
				min = Math.min(min, prefix[i-k]);
				max = Math.max(max, prefix[i] - min);
			}
			
		}
		return max == null ? 0 : max;
	}
