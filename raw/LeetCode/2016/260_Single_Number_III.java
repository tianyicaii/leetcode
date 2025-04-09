// https://leetcode.com/problems/single-number-iii/


public class Solution {


	public int[] singleNumber(int[] nums) {

		int XOR = 0;
		for (int i : nums) XOR ^= i;
		int x = XOR - (XOR & (XOR - 1));
		int a = 0, b = 0;
		for (int i : nums) {
			if ((x & i) == 0) a ^= i;
			else              b ^= i;
		}
		return new int[] {a, b};
	}


}

