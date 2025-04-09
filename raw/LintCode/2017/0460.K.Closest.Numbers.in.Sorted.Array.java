/*
 *  http://www.lintcode.com/en/problem/k-closest-numbers-in-sorted-array/
 *  Given a target number, a non-negative integer k and an integer array A sorted in ascending order,
 *  find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target.
 *  Sorted in ascending order by number if the difference is same.
 */

	public int[] kClosestNumbers (int[] A, int target, int k) {
		if (A.length == 0 || k <= 0 || k > A.length) return new int[] {};
		
		int[] ans = new int[k];
		int left = bsearch(A, target);
		int right = left + 1;

		for (int i = 0; i < k; i++) {
			if (left < 0) ans[i] = A[right ++];
			else if (right >= A.length) ans[i] = A[left --];
			else if (target - A[left] > A[right] - target) ans[i] = A[right ++];
			else ans[i] = A[left --];
		}
		return ans;
	}
	
	private int bsearch (int[] A, int target) {  // find last e such that e <= target
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
