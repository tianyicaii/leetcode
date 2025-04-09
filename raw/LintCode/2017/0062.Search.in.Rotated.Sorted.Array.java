/*
 *  http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
 *  Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *  You are given a target value to search. If found in the array return its index, otherwise return -1.
 *  You may assume no duplicate exists in the array.
 */

	public int search (int[] A, int target) {
		if (A == null || A.length == 0) return -1;
		int p = findMin(A);
		int i = bsearch(A, target, 0, p - 1);  // p might be 0
		int j = bsearch(A, target, p, A.length - 1);
		if (i != -1) return i;
		if (j != -1) return j;
		return -1;
	}

	private int findMin (int[] nums) {  // find pivot
		if (nums.length == 1) return 0;
		if (nums[0] < nums[nums.length - 1]) return 0;  // no rotation
		int left = 0;
		int right = nums.length - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[left]) left = mid;
			else right = mid;  // nums[mid] < nums[right]
		}
		return right;
	}

	private int bsearch (int[] A, int target, int left, int right) {
		if (left > right) return -1;  // interval might be empty
		if (A[left] == target) return left;
		if (A[right] == target) return right;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) return mid;
			else if (A[mid] < target) left = mid;
			else right = mid;
		}
		return -1;
	}
