
	public int maxProduct (int[] nums) {
		int local_max = nums[0];
		int local_min = nums[0];
		int global_max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prev_local_max = local_max;
			int prev_local_min = local_min;
			local_max = Math.max(Math.max(prev_local_max * nums[i],  prev_local_min * nums[i]), nums[i]);
			local_min = Math.min(Math.min(prev_local_max * nums[i],  prev_local_min * nums[i]), nums[i]);
			global_max = Math.max(global_max, local_max);
		}
		return global_max;
	}