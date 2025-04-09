// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/


public class Solution {
	

	public boolean search(int[] nums, int target) {
		if (nums.length == 0) return false;
		int left = 0;
		int right = nums.length - 1;
		if (nums[left] == target) return true;
		if (nums[right] == target) return true;
		
		while (left < right - 1) {
			
			int mid = left + (right - left) / 2;
			int M = nums[mid];
			int L = nums[left];
			int R = nums[right];
			
			if (M == target) return true;
			
			if      (L < M) {
				if (L < target && target < M) right = mid;
				else                          left  = mid;
			}
			else if (M < R) {
				if (M < target && target < R) left  = mid;
				else                          right = mid;
			}
			else if (L > M) {
				right = mid;  // [M ... R] all equal
			}
			else if (M > R) { // [L ... M] all equal
				left = mid;
			}
			else {  // L == M && M == R 
				right -= 1;
				if (nums[right] == target) return true;  // invariant : target is not at or before left,
														 // invariant : target is not at or after  right.
			}
		}
		
		return false;
	}	


}

