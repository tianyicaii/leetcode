// https://leetcode.com/problems/maximum-subarray/


public class Solution {


	public int maxSubArray (int[] nums) {
		if (nums.length == 0) throw new RuntimeException("empty array");
		
		int[] L = new int[2];
		int max = nums[0];
		
		for (int i = 1; i <= nums.length; i++) {
			L[i % 2] = Math.max(L[(i-1) % 2] + nums[i-1], nums[i-1]);
			max  = Math.max(max, L[i % 2]);
		}
		return max;
	}


}

