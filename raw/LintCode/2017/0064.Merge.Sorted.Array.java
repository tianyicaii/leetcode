/*
 *  http://www.lintcode.com/en/problem/merge-sorted-array/
 *
 *  Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *  You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 *  The number of elements initialized in A and B are m and n respectively.
 */

	public void mergeSortedArray (int[] A, int m, int[] B, int n) {
		
		int i = m + n - 1;
		m --;
		n --;
		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) A[i--] = A[m--];
			else A[i--] = B[n--];
		}
		while (m >= 0) A[i--] = A[m--];
		while (n >= 0) A[i--] = B[n--];
	}
