// https://leetcode.com/problems/number-of-1-bits/


public class Solution {


	public int hammingWeight (int n) {
		if (n == 0) return 0;
		return 1 + hammingWeight(n & n-1);  // remove last 1 bit
	}	


}

