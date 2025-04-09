/*
 *  http://www.lintcode.com/en/problem/partition-array/
 *
 *  Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *      All elements < k are moved to the left
 *      All elements >= k are moved to the right
 *      Return the partitioning index, i.e the first index i nums[i] >= k.
 */


// three-way partition
	public int partitionArray (int[] nums, int k) {
		int left = -1;
		int right = nums.length;
		int mid = 0;
		
		while (mid < right) {
			if (nums[mid] == k) mid ++;
			else if (nums[mid] < k) swap(nums, ++left, mid++);
			else swap(nums, --right, mid);
		}
		return left + 1;
	}
	
	void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}


// two-way partition
	public int partitionArray (int[] nums, int k) {
		
		// invariant:
		// (.. left] < k
		// [right ..) >= k;
		
		int left = -1;
		int right = nums.length;
		
		while (true) {
			while (left < right - 1 && nums[left + 1] < k) left ++;
			while (left < right - 1 && nums[right - 1] >= k) right --;  // not good for Q sort
			if (left >= right - 1) break;
			else swap(nums, ++left, --right);
		}
		return right;
	}
	
	void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
