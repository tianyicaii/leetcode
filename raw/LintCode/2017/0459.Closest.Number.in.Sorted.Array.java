/*
 *  http://www.lintcode.com/en/problem/closest-number-in-sorted-array/
 *
 *  Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.
 *  Return -1 if there is no element in the array.
 */

// binary search
	public int closestNumber (int[] A, int target) {
		if (A.length == 0) return -1;
		if (A[0] >= target) return 0;
		if (A[A.length - 1] <= target) return A.length - 1;
		
		int left = 0;
		int right = A.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) return mid;
			else if (A[mid] < target) left = mid;
			else right = mid;
		}
		
		if (A[right] - target < target - A[left]) return right;
		else return left;	
	}
