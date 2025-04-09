/*
 *  http://www.lintcode.com/en/problem/maximum-product-subarray/
 *
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */

	public int maxProduct (int[] nums) {
		
		int[] max = new int[nums.length];  // max[i] = subarray max product ending at element i
		int[] min = new int[nums.length];
		int result = nums[0];
		
		for (int i = 0; i < nums.length; i++) {
			
			if (i == 0) {
				max[i] = nums[i];
				min[i] = nums[i];
				
			} else {
				max[i] = Math.max(Math.max(nums[i], nums[i] * max[i-1]), nums[i] * min[i-1]);  // either glue or not, if glue, either to max or min.
				min[i] = Math.min(Math.min(nums[i], nums[i] * max[i-1]), nums[i] * min[i-1]);
			}
			
			result = Math.max(max[i], result);  // take the max seen so far
		}
		
		return result;
	}
