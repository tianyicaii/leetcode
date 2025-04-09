// https://leetcode.com/problems/jump-game/


public class Solution {


	public boolean canJump (int[] nums) {
		
		if (nums.length <= 1) return true;  // already win.
		
		int i = 0;
		int j = nums[0] + 0;
		while (i < nums.length) {  // try
			
			if (i > j) return false;  // cannot reach here.
			j = Math.max(j, i + nums[i]);  // as far as possible
			i++;

		}
		return true;  // i == nums.length
		
	}
	

}

