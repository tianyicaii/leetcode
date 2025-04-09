/*
 *  http://www.lintcode.com/en/problem/merge-two-sorted-arrays/
 *
 *  Merge two given sorted integer array A and B into a new sorted integer array.
 */

	public int[] mergeSortedArray (int[] A, int[] B) {
		int[] C = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) C[k++] = A[i++];
			else C[k++] = B[j++];
		}
		while (i < A.length) C[k++] = A[i++];
		while (j < B.length) C[k++] = B[j++];
		return C;
	}	
