
	public int findMin (int[] nums) {
		if (nums.length == 1) return nums[0];
		if (nums[0] < nums[nums.length - 1]) return nums[0];  // sorted
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[left]) left = mid;
			else right = mid;
		}
		return nums[right];
	}
