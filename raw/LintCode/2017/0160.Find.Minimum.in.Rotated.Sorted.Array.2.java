/*
 *  http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array-ii/
 *
 *  Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *  Find the minimum element.
 *  The array may contain duplicates.
 */

	public int findMin (int[] nums) {  // with duplicates
		if (nums == null || nums.length == 0) throw new RuntimeException("no solution");
		int min = nums[0];
		for (int i : nums)
			if (i < min) min = i;
		return min;
	}
