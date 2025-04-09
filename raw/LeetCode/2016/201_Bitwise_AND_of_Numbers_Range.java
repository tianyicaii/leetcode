// https://leetcode.com/problems/bitwise-and-of-numbers-range/


public class Solution {


	/*
	 * 00000 101010 010111 00000
	 * 00000 101010 111111 00000
	 * ----- ------ ------ -----
	 * 00000 101010 000000 00000
	 *              *  
	 * if m != n, there is a left most bits at which m is zero n is one
	 * this bit is zero in final result
	 * everything after this bit is zero
	 * everything before this bit is same as m (or n)
	 * 
	 */
	
	public int rangeBitwiseAnd (int m, int n) {
		int shift = 0;  // keep track of number of shifts
		while (m != n) {
			m >>= 1;
			n >>= 1;
			shift += 1;
		}
		return m << shift;
	}


}

