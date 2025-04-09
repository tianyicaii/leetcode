/*
 *  http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/#
 *
 *  There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 */

	public double findMedianSortedArrays (int[] A, int[] B) {
		int len = A.length + B.length;
		if (len % 2 == 0) return (findK(A, 0, B, 0, len / 2 - 1) + findK(A, 0, B, 0, len / 2)) / 2.0;
		else return findK(A, 0, B, 0, len / 2);
	}

	int findK (int[] A, int a, int[] B, int b, int k) {  //  k is the index for hypothetical merged two sub-arrays A[a...] and B[b...]
		if (a == A.length) return B[b + k];  // A is empty
		if (b == B.length) return A[a + k];  // B is empty
		if (k == 0) return Math.min(A[a], B[b]);  // base case, each iteration reduce k by half

		// eliminate first k elements, choose (k + 1) / 2 from each array
		
		int len = (k + 1) / 2;  // number of elements on the left half of each subarray
		int indexA = (a + len) <= A.length ? (a + len - 1) : A.length - 1;  // find last element form left half of each subarray
		int indexB = (b + len) <= B.length ? (b + len - 1) : B.length - 1;

		if (A[indexA] <= B[indexB]) return findK(A, indexA + 1, B, b, k - (indexA - a + 1));  // eleminate one of the left half of the subarray
		else return findK(A, a, B, indexB + 1, k - (indexB - b + 1));
	}
