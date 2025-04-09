// https://leetcode.com/problems/increasing-triplet-subsequence/


public class Solution {


	// find two numbers x1 < x2
	// if x3 > x2 return true;
	// else reduce x1 or x2. it won't eliminate triple with x1 and x2,
	// longest increasing subsequence (binary search method)
	
	public boolean increasingTriplet(int[] nums) {
		
		if (nums.length < 3) return false;
		int x1 = nums[0];
		int i = 1;
		while (i < nums.length && nums[i] <= x1) x1 = nums[i++];
		if (i == nums.length) return false;
		int x2 = nums[i];
		while (i < nums.length) {
			if (nums[i] > x2) return true;
			if (nums[i] <= x1) x1 = nums[i];
			else if (nums[i] <= x2) x2 = nums[i];
			i += 1;
		}
		
		return false;
	}


}

