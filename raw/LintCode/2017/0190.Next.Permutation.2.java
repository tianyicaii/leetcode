/*
 *  http://www.lintcode.com/en/problem/next-permutation-ii/
 *
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 */

	private void reverse (int[] nums, int beg, int end) {
		int left = beg;
		int right = end - 1;
		while (left < right) {
			swap (nums, left ++, right --);
		}
	}

	private void swap (int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	public int[] nextPermutation (int[] nums) {
		for (int i = nums.length - 1; i >= 1; i--) {
			if (nums[i] > nums[i-1]) {
				reverse(nums, i, nums.length);
				int j = i;
				while (nums[j] <= nums[i-1]) j++;
				swap(nums, i-1, j);
				return nums;
			}
		}

		reverse(nums, 0, nums.length);
		return nums;
	}
