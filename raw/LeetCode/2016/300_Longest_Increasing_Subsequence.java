// https://leetcode.com/problems/longest-increasing-subsequence/


public class Solution {
	

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}








	public int lengthOfLIS (int[] nums) {
		if (nums == null || nums.length == 0) return 0;

		int length = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			int index = bSearch(nums, 0, length - 1, nums[i]);
			nums[index] = nums[i];	//  reduce barrier. ***
			if (index == length) {
				length += 1;
				max = Math.max(max, length);
			}
		}
		return max;
	}

	// search insert locations
	private int bSearch (int[] nums, int left, int right, int x) {
		
		if (left > right) return left;  // empty, first location
		if (nums[left] > x) return left;  // all larger, first location
		if (nums[right] < x) return right + 1;  // all strictly smaller, expand

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			
			int L = nums[left];
			int R = nums[right];
			int M = nums[mid];

			if (M >= x) right = mid;
			else       left  = mid;
		}
		return right;  // first one larger
	}

}


