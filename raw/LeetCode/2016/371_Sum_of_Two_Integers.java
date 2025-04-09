// https://leetcode.com/problems/sum-of-two-integers/


public class Solution {


	public int getSum (int a, int b) {
		if (b == 0) return a;
		if (a == 0) return b;
		int sum = (a ^ b);
		int carry = (a & b) << 1;
		return getSum(sum, carry);
	}

	
}

