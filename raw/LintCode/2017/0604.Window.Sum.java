/*
 *  http://www.lintcode.com/en/problem/window-sum/
 *
 *  Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 *  find the sum of the element inside the window at each moving.
 */


	public int[] winSum (int[] nums, int k) {
		
		if (nums.length == 0 || k > nums.length || k <= 0) return new int[] {};
		int[] ans = new int[nums.length - k + 1];
		
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i+1 < k) ;
			else if (i+1 == k) {
				ans[0] = sum;
			} else {
				sum -= nums[i+1-k-1];
				ans[i+1-k] = sum;
			}
		}

		return ans;

	}
