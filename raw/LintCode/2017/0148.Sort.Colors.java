/*
 *  http://www.lintcode.com/en/problem/sort-colors/
 *
 *  Given an array with n objects colored red, white or blue,
 *  sort them so that objects of the same color are adjacent,
 *  with the colors in the order red, white and blue.
 *  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

// three way partition

	public void sortColors (int[] nums) {
		
		// invariant: (.. left] -> 0
		//            [right ..) -> 2
		//            (left, mid) -> 1
		//            [mid, right) -> to be processed
		
		int left = -1;
		int right = nums.length;
		int mid = 0;
		
		while (mid < right) {
			if (nums[mid] == 1) mid ++;
			else if (nums[mid] == 0) swap(nums, ++left, mid++);
			else swap(nums, --right, mid);
		}
	}
	
	void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
