// https://leetcode.com/problems/powx-n/


public class Solution {


	public double myPow (double x, int n) {

		if (n == 0 && x == 0) throw new RuntimeException("divide by zero");
		if (n == 0) return 1;
		boolean isNeg = (n < 0) ? true : false;
		
		
		double ans = 1;
		double xx  = x;
		
		while (n != 1 && n != -1) {
			if (n % 2 == 1 || n % 2 == -1) 
				ans *= xx;
			xx *= xx;
			n  /= 2;
		}
		
		ans *= xx;
		
		return isNeg ? 1 / ans : ans;
	}


}

