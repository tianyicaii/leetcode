/*
 *  http://www.lintcode.com/en/problem/partition-array-ii/
 *
 *  Partition an unsorted integer array into three parts:
 *      The front part < low
 *      The middle part >= low & <= high
 *      The tail part > high
 *      Return any of the possible solutions.
 */

	public void partition2 (int[] nums, int low, int high) {
		int left = -1;
		int right = nums.length;
		int next = 0;
		
		while (next < right) {
			if (nums[next] < low) swap(nums, ++left, next++);
			else if (nums[next] > high) swap(nums, --right, next);
			else next++;
		}
	}
	
	private void swap (int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
