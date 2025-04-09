
	public int searchInsert (int[] nums, int target) {
		if (nums.length == 0) return 0;
		if (nums[0] >= target) return 0;
		if (nums[nums.length - 1] < target) return nums.length;
		int left = 0;
		int right = nums.length;
		while (left + 1 < right) {  //  at least 3 elements
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) return mid;
			else if (nums[mid] < target) left = mid;
			else right = mid;
		}
		return right;
	}
