/*
 *  http://www.lintcode.com/en/problem/house-robber/
 *
 *  You are a professional robber planning to rob houses along a street.
 *  Each house has a certain amount of money stashed,
 *  the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 *  and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *  Given a list of non-negative integers representing the amount of money of each house,
 *  determine the maximum amount of money you can rob tonight without alerting the police.
 */

	public long houseRobber (int[] A) {
		long[] m = new long[A.length + 1];  // m[i] is the max for prefix of length i
		long[] e = new long[A.length + 1];  // e[i] is the max if rob A[i-1], this is not needed
		
		for (int i = 0; i <= A.length; i++) {
			if (i == 0) {
				m[0] = 0;
				e[0] = 0;
			} else if (i == 1) {
				m[1] = A[0];
				e[1] = A[0]; 
			} else {
				e[i] = A[i - 1] + m[i - 2];  // e[i] is not needed
				m[i] = Math.max(e[i], m[i - 1]);  // equivalently: m[i] = Math.max(A[i - 1] + m[i - 2], m[i - 1]);
			}
		}
		
		return m[A.length];
	}	

