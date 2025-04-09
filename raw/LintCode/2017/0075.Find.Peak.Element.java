/*
 *  http://www.lintcode.com/en/problem/find-peak-element/
 *
 *  There is an integer array which has the following features:
 *      The numbers in adjacent positions are different.
 *      A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 *  We define a position P is a peak if:
 *      A[P] > A[P-1] && A[P] > A[P+1]
 *  Find a peak element in this array. Return the index of the peak.
 */

	public int findPeak (int[] A) {
		int left = 0;
		int right = A.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
			else if (A[mid] < A[mid - 1]) right = mid;
			else left = mid;
		}
		throw new RuntimeException("invalid input");
	}
