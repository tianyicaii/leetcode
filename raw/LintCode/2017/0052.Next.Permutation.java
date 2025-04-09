/*
 *  http://www.lintcode.com/en/problem/next-permutation/#
 *
 *  Given a list of integers, which denote a permutation.
 *  Find the next permutation in ascending order.
 *  Notice
 *      The list may contains duplicate integers.
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
			if (nums[i] > nums[i-1]) {  // find a digit x such that there exist y, y > x and y appear after x
				reverse(nums, i, nums.length);  // change the suffix from decreasing to increasing, reverse() need to cooperate with finding digit to swap.
				int j = i;  // find digit to swap with nums[i-1]
				while (nums[j] <= nums[i-1]) j++;  // get the smallest digit y such that y > x, and swap y with x
				swap(nums, i-1, j);
				return nums;
			}
		}

		reverse(nums, 0, nums.length);  // 987654321 -> 123456789
		return nums;
	}
