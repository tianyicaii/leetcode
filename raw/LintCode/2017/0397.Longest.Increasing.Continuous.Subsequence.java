/*
 *  http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
 *
 *  Give an integer array，find the longest increasing continuous subsequence in this array.
 *  An increasing continuous subsequence:
 *      Can be from right to left or from left to right.
 *      Indices of the integers in the subsequence should be continuous.
 */

	public int longestIncreasingContinuousSubsequence (int[] A) {
	
		int ans = getMaxLength(A);
		reverse(A);
		ans = Math.max(ans, getMaxLength(A));
		return ans;
		
	}
	
	void reverse (int[] A) {
		int left = 0;
		int right = A.length - 1;
		while (left < right) {
			int t = A[left];
			A[left] = A[right];
			A[right] = t;
			left++;
			right--;
		}
	}
	
	int getMaxLength (int[] A) {
		int[] m = new int[A.length];
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0) m[i] = 1;
			else if (A[i] >= A[i - 1]) m[i] = m[i - 1] + 1;
			else m[i] = 1;
			ans = Math.max(ans, m[i]);
		}
		return ans;
	}

