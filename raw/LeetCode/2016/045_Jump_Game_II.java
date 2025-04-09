// https://leetcode.com/problems/jump-game-ii/


public class Solution {


	public int jump (int[] nums) {

		int left = 0;
		int right = 0;
		int numJumps = 0;
		
		while (right < nums.length - 1) {
			int reach = left + nums[left];
			for (int i = left + 1; i <= right; i++) {
				reach = Math.max(reach, nums[i] + i);
			}
			if (reach == right) return -1;
			left = right + 1;
			right = reach;
			numJumps += 1;
		}
		
		return numJumps;
	}


}

