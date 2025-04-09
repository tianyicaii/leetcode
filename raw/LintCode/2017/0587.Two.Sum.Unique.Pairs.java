/*
 *  http://www.lintcode.com/en/problem/two-sum-unique-pairs/
 *
 *  Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number.
 *  Please return the number of pairs.
 */

	public int twoSum6 (int[] nums, int target) {
		Map<Integer, Integer> cnt = new HashMap<>();
		int ans = 0;
		for (int x : nums) {
			int y = target - x;
			if (x == y) {
				if (cnt.containsKey(x) && cnt.get(x) == 1) ans += 1;
			} else {
				if (!cnt.containsKey(x) && cnt.containsKey(y)) ans += 1;
			}
			if (!cnt.containsKey(x)) cnt.put(x, 0);
			cnt.put(x, cnt.get(x) + 1);
		}
		
		return ans;
	}



	public int twoSum6 (int[] nums, int target) {

		Arrays.sort(nums);
		int ans = 0;
		int left = 0;
		int right = nums.length - 1;
		
		while (true) {
			
			
			while (left < right && left != 0 && nums[left] == nums[left - 1]) left++;
			while (left < right && right != nums.length - 1 && nums[right] == nums[right + 1]) right--;
			if (left >= right) break;
			
			int sum = nums[left] + nums[right];
			if (sum == target) {
				ans += 1;
				left += 1;
				right -= 1;
			} else if (sum < target) {
				left += 1;
			} else {
				right -= 1;
			}
			
		}
		
		return ans;
	}	
