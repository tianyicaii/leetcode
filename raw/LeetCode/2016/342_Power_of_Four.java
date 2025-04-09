// https://leetcode.com/problems/power-of-four/


public class Solution {


	public boolean isPowerOfFour(int num) {
		if (num <= 0) return false;
		if ((num & (num - 1)) != 0) return false;
		int mask = 0x55555555;
		return ((num & mask) != 0);
	}

}

