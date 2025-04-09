/*
 *  http://www.lintcode.com/en/problem/maximum-subarray/
 *
 *  Given an array of integers, find a contiguous subarray which has the largest sum.
 *  The subarray should contain at least one number.
 */


// global max is the max of all local max,
// local max at index i: subarray ending at index i
	public int maxSubArray (int[] nums) {
		
		int[] global = new int[2];
		int[] local = new int[2];  //  max ending at i

		global[0] = nums[0];  // The subarray should contain at least one number.
		local[0] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			local[i % 2] = Math.max((local[(i - 1) % 2] + nums[i]), nums[i]);  // either append or not append, only one sub-problem is needed, able to be greedy.
			global[i % 2] = Math.max(global[(i - 1) % 2], local[i % 2]);
		}

		return global[(nums.length - 1) % 2];
	}




// divide and conquer
	public int maxSubArray (int[] nums) {
		return dc(nums, 0, nums.length - 1);
	}
	int dc (int[] nums, int left, int right) {

		if (left == right) return nums[left];  // one elements left
		if (left == right - 1) return Math.max(nums[left], nums[right]);  // two elements left
		
		int mid = left + (right - left) / 2;  // able to split
		int L = 0;  //  signals that greedy is possible.
		int R = 0;
		for (int i = mid - 1, sum = 0; i >= left; i--) {
			sum += nums[i];
			L = Math.max(L, sum);
		}
		for (int i = mid + 1, sum = 0; i <= right; i++) {
			sum += nums[i];
			R = Math.max(R, sum);
		}
		return Math.max(Math.max(dc(nums, left, mid - 1), dc(nums, mid + 1, right)), L + R + nums[mid]);
	}




// prefix array + greedy
	public int maxSubArray (int[] nums) {
		
		int prefix_sum = nums[0];
		int prefix_min = 0;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prefix_min = Math.min(prefix_min, prefix_sum);
			prefix_sum += nums[i];
			max = Math.max(max, prefix_sum - prefix_min);
		}
		return max;
	}
