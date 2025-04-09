// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/


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
				
			if      (M > L) left = mid;
			else if (M < R) right = mid;
			else if (M < L) right = mid;
			else if (M > R) left  = mid;
			
			
			else if (nums[right - 1] <= R) right -= 1;
			else                           left  += 1;  // nums[left + 1] >= L
			

			
			
		}
		return nums[right];
	}	


}

