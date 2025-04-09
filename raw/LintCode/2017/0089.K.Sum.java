/*

http://www.lintcode.com/en/problem/k-sum/

Given n distinct positive integers, integer k (k <= n) and a number target.
Find k numbers where sum is target. Calculate how many solutions there are?

*/

	public int kSum (int[] A, int num, int target) {
		int[][][] M = new int[A.length + 1][num + 1][target + 1];
		
		for (int i = 0; i <= A.length; i++) {  // from i numbers
			for (int j = 0; j <= num; j++) {  // make j selections
				for (int k = 0; k <= target; k++) {  // for each sub-target
					
					
					if (j == 0 && k == 0) M[i][j][k] = 1;  // choose 0 numbers to get 0
					else if (j == 0 && k != 0) M[i][j][k] = 0;  // nothing to choose and cannot get target
					else if (i < j) M[i][j][k] = 0;  // choose more than we have
					else {
						M[i][j][k] = M[i-1][j][k];
						if (A[i-1] <= k) M[i][j][k] += M[i-1][j-1][k-A[i-1]];  // length is i, candidate is A[i-1]
					}
					
				}
			}
		}
		
		
		return M[A.length][num][target];
	}
