
	public int findMin (int[] nums) {
		if (nums.length == 1) return nums[0];
		int left = 0;
		int right = nums.length - 1;
		while (left < right && nums[left] == nums[right]) left++;
		if (nums[left] <= nums[right]) return nums[left];
		
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= nums[left]) left = mid;
			else right = mid;
		}
		return nums[right];
	}

