// https://leetcode.com/problems/first-missing-positive/


public class Solution {


	public int firstMissingPositive(int[] nums) {
		
		// p should be in nums[p-1] for p >= 1 && p <= nums.length
		int i = 0;
		while (i < nums.length) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				i ++; 
				continue;  // ignore out of range
			}
			if (nums[nums[i] - 1] != nums[i])  // my location is occupied by others
				swap(nums, i, nums[i] - 1);  // put me back to my location
			else {
				i ++;  // in correct place.
			}
		}

		
		for (int j = 0; j < nums.length; j++) 
			if (nums[j] != j + 1) return j + 1;
		return nums.length + 1;  // no one missing.
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}


}

