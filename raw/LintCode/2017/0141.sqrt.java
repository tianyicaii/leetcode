/*
 *  http://www.lintcode.com/en/problem/sqrtx/
 *
 *  Implement int sqrt(int x). Compute and return the square root of x.
 */

	public int sqrt (int x) {
		if (x == 0) return 0;
		if (x == 1) return 1;
		long left = 1;
		long right = x;
		while (right - left > 1) {
			long mid = left + (right - left) / 2;
			long s = mid * mid;
			if (s == x) return (int)mid;
			else if (s < x) left = mid;
			else right = mid;
		}
		return (int)left;
	}
