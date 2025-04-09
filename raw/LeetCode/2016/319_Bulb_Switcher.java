// https://leetcode.com/problems/bulb-switcher/


public class Solution {

	public int bulbSwitch(int n) {

		// divisor are in pairs except squares
		// count number of squares <= n;
		// each square root <= sqrt(n) gives a square

		return (int)Math.sqrt(n);
	}


}

