/*
 *  http://www.lintcode.com/en/problem/move-zeroes/
 *
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */

	public void moveZeroes (int[] nums) {

		int next = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) continue;
			else nums[next++] = nums[i];
		}
		for (; next < nums.length; next++) {
			nums[next] = 0;
		}

	}
