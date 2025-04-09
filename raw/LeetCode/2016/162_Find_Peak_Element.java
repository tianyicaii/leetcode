// https://leetcode.com/problems/find-peak-element/


public class Solution {
	

	public int findPeakElement(int[] nums) {
		if (nums.length == 1) return 0;
		if (nums[1] < nums[0]) return 0;
		if (nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;
		
		int left = 0;  // invariant : nums[left] is not peak
		int right = nums.length - 1;  // invariant : nums[right] is not peak
		
		while (true) {  // must have peak, at least 3 elements
			
			int mid = (left + right) / 2;
			int M   = nums[mid];
			if (M > nums[mid - 1] && M > nums[mid + 1]) return mid;
			if (M < nums[mid - 1]) right = mid;
			else                   left  = mid;
			
		}
	}	


}

