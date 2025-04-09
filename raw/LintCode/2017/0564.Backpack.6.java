/*

http://www.lintcode.com/en/problem/backpack-vi/

Given an integer array nums with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.

Notice: A number in the array can be used *multiple times* in the combination. 
Different *orders* are counted as different combinations.

*/


	public int backPackVI (int[] nums, int target) {
		

		int[] mem = new int[target + 1];  // number of ways for sub-target j can be achieved for first i items
		mem[0] = 1;
		
		for (int j = 1; j <= target; j++) {  // for each sub-target
			for (int i = 0; i < nums.length; i++) {  // for each item
				if (nums[i] <= j) mem[j] += mem[j - nums[i]];
			}
		}
		
		return mem[target];
	}
