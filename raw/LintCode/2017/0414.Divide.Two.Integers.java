/*
 *  http://www.lintcode.com/en/problem/divide-two-integers/
 *
 *  Divide two integers without using multiplication, division and mod operator.
 *  If it is overflow, return 2147483647
 */

	public int divide (int dividend, int divisor) {
		if (divisor == 0) throw new RuntimeException("divided by zero");
		if (dividend == 0) return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

		int sign = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
		long n = Math.abs((long)dividend);
		long d = Math.abs((long)divisor);
		
		int q = 0;
		while (n >= d) {
			long t = d;
			long i = 1;
			while (n >= t) {
				t <<= 1;
				i <<= 1;
			}
			t >>= 1;
			i >>= 1;
			n -= t;
			q += i;
		}
		
		return sign * q;
	}
