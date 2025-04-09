/*
 *  http://www.lintcode.com/en/problem/coins-in-a-line-ii/
 *
 *  There are n coins with different value in a line.
 *  Two players take turns to take one or two coins from left side until there are no more coins left.
 *  The player who take the coins with the most value wins.
 *  Could you please decide the first player will win or lose?
 */


	public boolean firstWillWin (int[] values) {
		reverse(values);

		int[] prefixSum = new int[values.length + 1];  // total value for each subarray
		for (int i = 0; i <= values.length; i++) {
			if (i == 0) prefixSum[i] = 0;
			else prefixSum[i] = prefixSum[i - 1] + values[i - 1];
		}
		
		int[] m = new int[values.length + 1];
		for (int i = 0; i <= values.length; i++) {
			if (i == 0) m[i] = 0;
			else if (i == 1) m[i] = prefixSum[1];
			else if (i == 2) m[i] = prefixSum[2];
			else m[i] = Math.max(prefixSum[i] - m[i - 1], prefixSum[i] - m[i-2]);  // whichever makes the other take less

		}
		return prefixSum[values.length] < 2 * m[values.length];
	}	


	void reverse (int[] values) {  // change it to take from right to left, so that indices walk from left to right
		int left = 0;
		int right = values.length - 1;
		while (left < right) {
			int tmp = values[left];
			values[left] = values[right];
			values[right] = tmp;
			left ++;
			right --;
		}
	}

