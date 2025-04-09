/*
 *  http://www.lintcode.com/en/problem/sqrtx-ii/
 *
 *  Implement double sqrt(double x) and x >= 0. Compute and return the square root of x.
 */

	public double sqrt(double x) {
		double e = 1e-15;
		double t = 1;
		while (Math.abs(t * t - x) > x * e) {
			t = (t + x/t) / 2;
		}
		return t;
	}
