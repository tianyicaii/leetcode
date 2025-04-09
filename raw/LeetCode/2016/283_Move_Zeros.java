// https://leetcode.com/problems/move-zeroes/


public class Solution {
	

	public void moveZeroes (int[] nums) {
		int i = 0;  // current under scan
		int j = 0;  // next available position
		while (i < nums.length) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
			i++;
		}
		while (j < nums.length) {
			nums[j] = 0;
			j++;
		}
	}


}

