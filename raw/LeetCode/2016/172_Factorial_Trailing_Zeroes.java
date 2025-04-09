// https://leetcode.com/problems/factorial-trailing-zeroes/


public class Solution {


	public int trailingZeroes (int n) {
		int numOfFives = 0;
		while (n >= 5) {
			int multiples = n / 5;
			numOfFives += multiples;
			n = n / 5;
		}
		return numOfFives;
	}


}

