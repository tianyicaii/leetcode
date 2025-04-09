/*
 *  http://www.lintcode.com/en/problem/total-occurrence-of-target/
 *
 *  Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.
 */

	public int findLast (int[] A, int target) {  // find last element e such that e <= target
		if (A.length == 0) return -1;
		if (A[0] > target) return -1;
		if (A[A.length - 1] <= target) return A.length - 1;
		int left = 0;
		int right = A.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] <= target) left = mid;
			else right = mid;
		}
		return left;
	}
	
	public int totalOccurrence(int[] A, int target) {
		if (A.length == 0) return 0;
		if (A[0] > target) return 0;
		if (A[A.length - 1] < target) return 0;
		
		int first = findLast(A, target - 1) + 1;  // points to first element > target if target does not exist
		int last = findLast(A, target);  // points to last elements < target if not exist
		if (first > last) return 0;  // might not exist
		else return last - first + 1;
	}
