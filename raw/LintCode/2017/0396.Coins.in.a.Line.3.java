/*
 *  http://www.lintcode.com/en/problem/coins-in-a-line-iii/
 *
 *  There are n coins in a line.
 *  Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
 *  The player with the larger amount of money wins.
 *  Could you please decide the first player will win or lose?
 */

// need two numbers to specify a problem, the starting offset and the length of the subarray.

	public boolean firstWillWin (int[] values) {
		
		int[] prefixSums = new int[values.length + 1];
		for (int i = 0; i <= values.length; i++) {
			if (i == 0) prefixSums[i] = 0;
			else prefixSums[i] = prefixSums[i - 1] + values[i - 1];
		}
	
		int[][] m = new int[values.length + 1][values.length];  // length of the subarray, starting position of the subarray.
		for (int i = 1; i <= values.length; i++) {  // i == 0, m[i][j] = 0;
			for (int j = 0; j + i <= values.length; j++) {
				
				
				if (i == 1) m[i][j] = values[j];
				else {
					//  get one either from left or right
					int sum = prefixSums[j + i] - prefixSums[j];  // total value for this sub-problem
					m[i][j] = Math.max(sum - m[i - 1][j + 1], sum - m[i - 1][j]);
				}
				

			}
		}
		
		return m[values.length][0] > prefixSums[values.length] / 2;
	}
