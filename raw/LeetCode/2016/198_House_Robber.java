// https://leetcode.com/problems/house-robber/


public class Solution {


	public int rob (int[] nums) {
		int[] dp = new int[nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			if      (i == 0) dp[i] = 0;
			else if (i == 1) dp[i] = nums[0];
			else             dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
		}
		return dp[nums.length];
	}


}

