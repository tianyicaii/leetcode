/*

http://www.lintcode.com/en/problem/burst-balloons/

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.
	- You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
	- 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 */


// pick one as the last balloon to burst, so that sub-problem is fixed
// if pick the balloon first to burst, sub-problem changes as different ways to reach to that sub-array


	public int maxCoins (int[] nums) {
		
		if (nums.length == 0) return 0;

		
		
		
		int[][] M = new int[nums.length + 1][nums.length];
		
		for (int i = 1; i <= nums.length; i++) {  // sub-array length
			for (int j = 0; j + i <= nums.length; j++) {  // offset of sub-array of length i
				

				if (i == 1) M[i][j] = (j == 0 ? 1 : nums[j-1]) * nums[j] * (i+j == nums.length ? 1 : nums[i+j]);
				else {  // find a last burst point
					for (int k = j; k < j+i; k++) {  // divide at element k
						

						M[i][j] = Math.max(M[i][j],
												(k == j ? 0 : M[k-j][j]) + 
												(k == j+i-1 ? 0 : M[i-(k-j+1)][k+1]) + 
														(j == 0 ? 1 : nums[j-1]) * 
														nums[k] * 
														(i+j == nums.length ? 1 : nums[i+j]));
						
								
					}
				}
				
				
			}
		}
		
		
		return M[nums.length][0];  // entire array starting at offset 0
	}
