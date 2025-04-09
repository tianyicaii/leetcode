
	public int maxSubArray (int[] nums) {
		return divide_conquer(nums, 0, nums.length - 1);
	}

	int divide_conquer (int[] nums, int L, int R) {
		if (L > R) return Integer.MIN_VALUE;

		int M = L + (R - L) / 2;
		int leftMax = 0;
		int rightMax = 0;
		int leftSum = 0;
		int rightSum = 0;
		for (int i = M - 1; i >= L; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}
		for (int i = M + 1; i <= R; i++ ) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax, rightSum);
		}
		return Math.max(leftMax + nums[M] + rightMax,
				Math.max(divide_conquer(nums, L, M - 1), divide_conquer(nums, M + 1, R)));
	}

	public int maxSubArray (int[] nums) {
		int global = nums[0];
		int local = nums[0];
		for (int i = 1; i < nums.length; i++) {
			local = Math.max(nums[i], local + nums[i]);
			global = Math.max(local, global);
		}
		return global;
	}