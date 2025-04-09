/*
 *  http://www.lintcode.com/en/problem/search-for-a-range/
 *
 *  Given a sorted array of n integers, find the starting and ending position of a given target value.
 *  If the target is not found in the array, return [-1, -1].
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
	
	public int[] searchRange (int[] A, int target) {
		if (A.length == 0) return new int[] {-1, -1};
		if (A[0] > target) return new int[] {-1, -1};
		if (A[A.length - 1] < target) return new int[] {-1, -1};
		
		int first = findLast(A, target - 1) + 1;
		int last = findLast(A, target);
		if (first > last) return new int[] {-1, -1};
		else return new int[] {first, last}; 
	}
