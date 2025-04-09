// https://leetcode.com/problems/wiggle-subsequence/


public class Solution {


	public int wiggleMaxLength (int[] nums) {
		if (nums == null || nums.length == 0) return 0;


		int i = 1;
		while (i < nums.length && nums[i - 1] == nums[i]) i++;
		if (i == nums.length) return 1;  // all equal

		int dir;  // was increasing or decreasing ?
		if (nums[i] > nums[i - 1]) dir =  1;
		else                       dir = -1;

		int max = 2;
		int prev = nums[i];
		i += 1;
		
		while (i < nums.length) {
			int curr = nums[i];
			
			if (curr > prev) {
				if (dir == -1) {
					prev = curr;
					max += 1;
					dir = 1;
				}
				else {
					prev = curr;
				}
			}
			else if (curr < prev) {
				if (dir == 1) {
					prev = curr;
					max += 1;
					dir = -1;
				}
				else {
					prev = curr;
				}
			}
			else {  // curr == prev
				;  // do nothing
			}

			i++;
		}

		return max;
	}


}

