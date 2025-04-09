/*
 *  http://www.lintcode.com/en/problem/maximum-average-subarray/
 *
 *  Given an array with positive and negative numbers, find the maximum average subarray which length should be *greater or equal to given length k*.
 */

	public double maxAverage (int[] nums, int k) {
		
		double max = nums[0];
		double min = nums[0];
		for (int i : nums) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		if (isValid(nums, k, max)) return max;
		while (max - min > 1e-10) {
			double mid = min + (max - min) / 2;
			if (isValid(nums, k, mid)) min = mid;
			else max = mid;
		}
		return min;
	}


	private boolean isValid (int[] nums, int k, double guess) {  // it is easier to check some average is possible than to find the max average
		double[] prefixSum = new double[nums.length + 1];
		double minSum = 0.0;
		for (int i = 1; i <= nums.length; i++) {
			prefixSum[i] = prefixSum[i-1] + nums[i-1] - guess;
			if (i >= k) {
				minSum = Math.min(minSum, prefixSum[i - k]);
				if (prefixSum[i] - minSum > 0) return true;
			}
		}
		return false;
	}
