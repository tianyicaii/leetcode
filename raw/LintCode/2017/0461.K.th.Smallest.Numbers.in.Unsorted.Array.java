/*
 *  http://www.lintcode.com/en/problem/kth-smallest-numbers-in-unsorted-array/
 *
 *  Find the kth smallest numbers in an unsorted integer array.
 */

	public int kthSmallest (int k, int[] nums) {
		
		k -= 1;
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




// 2-way partition

	public int kthSmallest (int k, int[] nums) {
		
		k -= 1;
		Random r = new Random();
		int left = 0;
		int right = nums.length - 1;
		
		while (true) {
			int x = r.nextInt(right - left + 1) + left;
			int p = partition2(nums, left, right, x);
			System.out.println(Arrays.toString(nums) + ", p = " + p);
			if (p == k) return nums[p];
			if (p > k) right = p - 1;
			else left = p + 1;
		}
	}
	
	private int partition2 (int[] nums, int left, int right, int p) {
		
		swap(nums, left, p);
		int i = left;
		int j = right + 1;
		
		while (true) {
			
			while (i + 1 < j && nums[i + 1] < nums[left]) i++;
			while (j - 1 > i && nums[j - 1] > nums[left]) j--;
			if (i >= j - 1) break;
			else swap(nums, ++i, --j);
			
		}
		
		swap(nums, left, i);
		return i;
	}
	
	void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
