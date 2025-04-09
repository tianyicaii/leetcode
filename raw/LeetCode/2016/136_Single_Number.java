// https://leetcode.com/problems/single-number/


public class Solution {
	

	public int singleNumber (int[] nums) {
		int x = 0;
		for (int i : nums)
			x ^= i;
		return x;
	}


}

