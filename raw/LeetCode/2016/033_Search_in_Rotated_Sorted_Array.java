// https://leetcode.com/problems/search-in-rotated-sorted-array/


public class Solution {


	public int search (int[] nums, int target) {	
		if (nums.length == 0) return -1;
		
		int left = 0;
		int right = nums.length - 1;
		if (nums[left]  == target) return left;
		if (nums[right] == target) return right;
		
		while (left < right - 1) {
			
			int mid = left + (right - left) / 2;
			int M = nums[mid];
			int L = nums[left];
			int R = nums[right];
			
			if (M == target) return mid;
			if (M > L) {
				if (L < target && target < M) right = mid;
				else                          left  = mid;
			}
			else {
				if (M < target && target < R) left  = mid;
				else                          right = mid;
			}
		}
		
		return -1;
	}


}

