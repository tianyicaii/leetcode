// https://leetcode.com/problems/divide-two-integers/


public class Solution {
	

	public int divide (int dividend, int divisor) {
		
		if (divisor == 0) throw new ArithmeticException("divide by zero");  // divide by zero
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;  // overflow
		
		int sign = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
			
		long D = Math.abs((long) dividend);
		long d = Math.abs((long) divisor);
		long quo = 0;
		
		while (D >= d) {
			
			long dd = d;
			long q  = 1;
			while (D >= dd) {
				dd <<= 1;  // multiply by two
				q  <<= 1;  // multiples
			}
			dd >>= 1;
			q >>= 1;  // once too many;
			
			D -= dd;
			quo += q;
		} 
		return sign * (int)quo;
	}


}

