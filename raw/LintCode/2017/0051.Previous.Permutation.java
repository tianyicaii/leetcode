/*
 *  http://www.lintcode.com/en/problem/previous-permutation/#
 *
 *  Given a list of integers, which denote a permutation.
 *  Find the previous permutation in ascending order.
 *  Notice
 *      The list may contains duplicate integers.
 */

	private void reverse (List<Integer> list, int beg, int end) {
		int left = beg;
		int right = end - 1;
		while (left < right) {
			swap (list, left ++, right --);
		}
	}

	private void swap (List<Integer> list, int a, int b) {
		int tmp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, tmp);
	}
	
	public List<Integer> previousPermuation (List<Integer> nums) {
		

		for (int i = nums.size() - 1; i >= 1; i--) {
			if (nums.get(i) < nums.get(i-1)) {
				reverse(nums, i, nums.size());
				int j = i;
				while (nums.get(j) >= nums.get(i-1)) j++;
				swap(nums, i-1, j);
				return nums;
			}
		}
		
		reverse(nums, 0, nums.size());  // 123456789 -> 987654321
		return nums;
	}

// eg:
// 18579 -> 17985