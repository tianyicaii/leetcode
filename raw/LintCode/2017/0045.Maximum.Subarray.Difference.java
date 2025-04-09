/*
 *  http://www.lintcode.com/en/problem/maximum-subarray-difference/#
 *
 *  Given an array with integers.
 *  Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 *  Return the largest difference.
 */

	public int maxDiffSubArrays (int[] nums) {
		
		int[] leftMax = getMax(nums);
		int[] leftMin = getMin(nums);
		reverse(nums);
		int[] rightMax = getMax(nums);
		int[] rightMin = getMin(nums);
		Integer ans = null;
		for (int left = 1; left < nums.length; left++) {  // find the division point, take max min from left and right to get global max
			int right = nums.length - left;
			if (ans == null) ans = Math.max(Math.abs(leftMax[left] - rightMin[right]), Math.abs(rightMax[right] - leftMin[left]));
			else ans = Math.max(ans, Math.max(Math.abs(leftMax[left] - rightMin[right]), Math.abs(rightMax[right] - leftMin[left])));
		}
		return ans;
	}
	
	private int[] getMax (int[] nums) {
		int[] local = new int[nums.length + 1];
		int[] ans = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			if (i == 1) {
				local[i] = nums[i-1];
				ans[i] = nums[i-1];
			} else {
				local[i] = Math.max(nums[i-1], local[i-1] + nums[i-1]);
				ans[i] = Math.max(ans[i-1], local[i]);
			}
		}
		return ans;
	}
	
	private int[] getMin (int[] nums) {
		int[] local = new int[nums.length + 1];
		int[] ans = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			if (i == 1) {
				local[i] = nums[i-1];
				ans[i] = nums[i-1];
			} else {
				local[i] = Math.min(nums[i-1], local[i-1] + nums[i-1]);
				ans[i] = Math.min(ans[i-1], local[i]);
			}
		}
		return ans;
	}
	
	private void reverse (int[] nums) {
		for (int i = 0, j = nums.length - 1; i < j; ++i, --j) swap(nums, i, j);
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
