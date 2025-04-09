/*
 *  http://www.lintcode.com/en/problem/kth-largest-element/#
 *
 *  Find K-th largest element in an array.
 */


	public int kthLargestElement (int k, int[] nums) {
		
		k = nums.length - k;  // find k th smallest
		Random r = new Random();
		int left = 0;
		int right = nums.length - 1;
		
		while (true) {
			int x = nums[r.nextInt(right - left + 1) + left];
			int[] range = partition3(nums, left, right, x);
			if (range[0] <= k && k <= range[1]) return x;
			if (range[0] > k) right = range[0] - 1;
			else left = range[1] + 1;
		}
	}
	
	public int[] partition3 (int[] nums, int left, int right, int x) {

		left -= 1;
		right += 1;
		int mid = left + 1;
		
		while (mid < right) {
			if (nums[mid] == x) mid ++;
			else if (nums[mid] < x) swap(nums, ++left, mid++);
			else swap(nums, --right, mid);
		}

		return new int[] {left + 1, right - 1};
	}
	
	void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
