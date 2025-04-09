// https://leetcode.com/problems/search-insert-position/


public class Solution {


	public int searchInsert (int[] nums, int target) {
		if (nums.length == 0) return 0;
		if (nums[0] >= target) return 0;
		if (nums[nums.length - 1] < target) return nums.length;
		int left = 0;
		int right = nums.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			int M = nums[mid];
			if (M == target) return mid;
			if (M <  target) left = mid;
			else            right = mid;
		}
		return right;
	}


}

