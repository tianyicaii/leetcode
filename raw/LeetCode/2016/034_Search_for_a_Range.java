// https://leetcode.com/problems/search-for-a-range/


public class Solution {


	public int[] searchRange (int[] nums, int target) {
		
		int[] notFound = new int[] {-1, -1};
		if (nums.length == 0) return notFound;
		
		int start;
		int end;
		
		int left = 0;
		int right = nums.length - 1;
		
		if (nums[0] == target) start = 0;
		else {
			while (left < right - 1) {
				int mid = left + (right - left) / 2;
				int M = nums[mid];
				if (M < target) left  = mid;
				else            right = mid;
			}
			if (nums[right] != target) return notFound;
			else start = right;
		}
		
		left = 0;
		right = nums.length - 1;
		if (nums[right] == target) end = nums.length - 1;
		else {
			while (left < right - 1) {
				int mid = left + (right - left) / 2;
				int M = nums[mid];
				if (M > target) right = mid;
				else             left = mid;
			}
			end = left;
		}
		
		return new int[] {start, end};
	}	


}

