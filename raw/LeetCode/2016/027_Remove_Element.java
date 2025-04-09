// https://leetcode.com/problems/remove-element/


public class Solution {
	


	public int removeElement (int[] nums, int val) {
		
		if (nums.length == 0) return 0;
		
		int i = -1;  // invariant: everything at or before i does not equal val
		int j = nums.length;  // invariant: everything at or after j equals val
		
		while (true) {
			while (nums[++i] != val)
				if (i == nums.length - 1) break;
			while (nums[--j] == val)
				if (j == 0) break;  // check after advance
			if (i >= j) break;
			swap(nums, i, j);
		}
		return (nums[j] != val) ? j + 1 : j;
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}




	public int removeElement (int[] nums, int val) {
		
		if (nums.length == 0) return 0;
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			while (left < right && nums[left] != val) left ++;
			while (left < right && nums[right] == val) right --;
			if (left < right)
				swap(nums, left, right);
		}
		
		return nums[left] == val ? left : left + 1;  // the element pointed by both left and right is not checked
	}
	
	private void swap (int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	
}

