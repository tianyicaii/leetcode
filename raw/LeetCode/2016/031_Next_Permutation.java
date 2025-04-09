// https://leetcode.com/problems/next-permutation/


public class Solution {


	public void nextPermutation (int[] nums) {
		
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] < nums[j]) {
					swap(nums, i, j);
					for (int x = i+1, y = nums.length - 1; x < y; x++, y--)
						swap(nums, x, y);
					return;
				}
			}
		}
		
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) 
			swap(nums, i, j);
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}


}

