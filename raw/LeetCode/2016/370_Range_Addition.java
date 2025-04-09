// https://leetcode.com/problems/range-addition/


public class Solution {


	public int[] getModifiedArray (int length, int[][] updates) {
		int[] nums = new int[length];
		for (int[] u : updates) {
			int left  = u[0];
			int right = u[1];
			int incr  = u[2];
			nums[left] += incr;
			if (right + 1 < length)
				nums[right + 1] -= incr;
		}
		
		int[] ans = new int[length];
		ans[0] = nums[0];
		for (int i = 1; i < length; i++) {
			ans[i] = ans[i-1] + nums[i];
		}
		return ans;
	}


}

