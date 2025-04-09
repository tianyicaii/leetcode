// https://leetcode.com/problems/house-robber-ii/


public class Solution {


	public int rob (int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0]; // special case, two consecutive rub.
		return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
	}
	
	// normal non-circular
	private int helper (int[] nums, int left, int right) {
		int length = right - left + 1;
		if (length <= 0) return 0; // empty sub-array
		int[] dp = new int[length + 1];
		for (int i = 0; i <= length; i++) {  // length of sub-array
			if      (i == 0) dp[i] = 0;
			else if (i == 1) dp[i] = nums[left + i - 1];
			else             dp[i] = Math.max(dp[i-1], dp[i-2] + nums[left + i - 1]);
		}
		return dp[length];
	}


}

