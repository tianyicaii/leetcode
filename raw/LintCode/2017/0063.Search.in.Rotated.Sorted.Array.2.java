/*
 *  http://www.lintcode.com/en/problem/search-in-rotated-sorted-array-ii/
 *
 *  Follow up for Search in Rotated Sorted Array:
 *  What if duplicates are allowed?
 *  Would this affect the run-time complexity? How and why?
 *  Write a function to determine if a given target is in the array.
 */

	public boolean search (int[] A, int target) {
		if (A == null || A.length == 0) return false;
		if (A[0] == target || A[A.length - 1] == target) return true;
		int left = 0;
		int right = A.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) return true;
			
			if (A[mid] > A[left]) {  // if A is not rotated then this case covers entire array
				if (A[left] < target && target < A[mid]) right = mid;
				else left= mid;
			} else if (A[mid] < A[right]) {
				if (A[mid] < target && target < A[right]) left = mid;
				else right = mid;
			} else {  // A[mid] == A[left] && A[mid] == A[right]
				left += 1;
			}

		}
		return false;
	}	
