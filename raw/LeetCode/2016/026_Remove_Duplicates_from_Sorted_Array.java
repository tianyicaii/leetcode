// https://leetcode.com/problems/remove-duplicates-from-sorted-array/


public class Solution {


	public int removeDuplicates (int[] nums) {
		
		if (nums.length == 0) return 0;
		
		// at least one element
		int prev = 0;  // last element being placed
		int curr = 1;  // current element under scan
		
		while (curr < nums.length) {
			if (nums[prev] == nums[curr]) curr += 1;
			else {
				prev += 1;
				nums[prev] = nums[curr];
				curr += 1;
			}
		}
		
		return prev + 1;
	}


}

