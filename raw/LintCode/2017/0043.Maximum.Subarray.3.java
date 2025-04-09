/*
 *  http://www.lintcode.com/en/problem/maximum-subarray-iii/#
 *
 *  Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
 *  The number in each subarray should be contiguous.
 *  Return the largest sum.
 */

	public int maxSubArray (int[] nums, int k) {

		int[][] local = new int[k + 1][nums.length + 1];
		int[][] global = new int[k + 1][nums.length + 1];
		
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= nums.length; j++) {  // the length of prefix containing i segments, at least one element each segment
				
				
				
				if (i == 1 && j == 1) {  // one element, one sub-array
					local[i][j] = nums[j-1];
					global[i][j] = nums[j-1];
				} else if (j == i) {  // one element each sub-array
					local[i][j] = global[i-1][j-1] + nums[j-1];
					global[i][j] = global[i-1][j-1] + nums[j-1];
				} else {
					local[i][j] = Math.max(nums[j-1] + global[i-1][j-1], nums[j-1] + local[i][j-1]);  // glue or not glue nums[j-1] to previous segment for segment i
					global[i][j] = Math.max(global[i][j-1], local[i][j]);
				}



			}
		}
		return global[k][nums.length];
	}
