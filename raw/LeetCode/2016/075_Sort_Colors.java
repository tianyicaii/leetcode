// https://leetcode.com/problems/sort-colors/


public class Solution {
	

	public void sortColors (int[] nums) {

		int left  = -1;  			// invariant: everything at or before left is 0
		int right = nums.length;  	// invariant: everything at or after right is 2
		int i     = 0;  			// invariant: i is current being scanned
		
		while (i < right) {
			int c = nums[i];
			if (c == 0) {
				swap(nums, left + 1, i);
				left ++;
				i ++;
			}
			else if (c == 1) {
				i ++;
			}
			else {  // c == 2
				swap(nums, right - 1, i);  // do not increase i
				right --;
			}
		}
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}


}

