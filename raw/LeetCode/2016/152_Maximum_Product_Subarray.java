// https://leetcode.com/problems/maximum-product-subarray/


public class Solution {
	

	public int maxProduct (int[] nums) {
		
		if (nums == null || nums.length == 0) return 0;
				
		int[] min = new int[nums.length];
		int[] max = new int[nums.length];
		int[] G   = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			
			if (i == 0) {
				min[i] = nums[i];
				max[i] = nums[i];
				  G[i] = nums[i];				
			}
			else {
				min[i] = nums[i];
				min[i] = Math.min(min[i], min[i-1] * nums[i]);
				min[i] = Math.min(min[i], max[i-1] * nums[i]);
								
				max[i] = nums[i];
				max[i] = Math.max(max[i], min[i-1] * nums[i]);
				max[i] = Math.max(max[i], max[i-1] * nums[i]);
								
				G[i] = Math.max(max[i], G[i-1]);
			}
		}
		
		return G[nums.length - 1];
	}	


}

