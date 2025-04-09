// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


public class Solution {
	

	public int removeDuplicates (int[] nums) {
		
		if (nums.length <= 2) return nums.length;
		
		int i = 2;
		int j = 2;  // j points next slot
		
		while (i < nums.length) {
			if (nums[i] == nums[j-2]) i++;
			else nums[j++] = nums[i++];
		}
		
		return j;
	}


}

