/*
 *  http://www.lintcode.com/en/problem/climbing-stairs-ii/#
 *
 *  A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
 *  Implement a method to count how many possible ways the child can run up the stairs.
 */

	public int climbStairs2 (int n) {
		if (n == 0) return 1;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		int[] A = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i == 1) A[i] = 1;
			else if (i == 2) A[i] = 2;
			else if (i == 3) A[i] = 4;
			else {
				for (int j = 1; j <= 3; j++) {
					A[i] += A[i-j];
				}
			}
		}
		
		return A[n];
	}	
