// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


public class Solution {
	

	public int findMin (int[] nums) {
		if (nums.length == 1) return nums[0];
		if (nums[0] < nums[nums.length - 1]) return nums[0];
		int left = 0;  // invariant : everything before or at left is not min
		int right = nums.length - 1;  // invariant : everything after right is not min;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			int M   = nums[mid];
			int L   = nums[left];
			int R   = nums[right];
			if (M > L) left = mid;
			else      right = mid;
		}
		return nums[right];
	}	


}

