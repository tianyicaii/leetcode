// https://leetcode.com/problems/missing-number/


public class Solution {
	

	public int missingNumber (int[] nums) {
		int n = nums.length;
		int XOR = 0;
		for (int i = 0; i < n; i++) {
			XOR ^= nums[i];
			XOR ^= i;
		}
		XOR ^= n;
		return XOR;
	}


}

