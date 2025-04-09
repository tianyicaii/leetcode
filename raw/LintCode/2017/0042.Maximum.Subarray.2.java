/*
 *  http://www.lintcode.com/en/problem/maximum-subarray-ii/#
 *
 *  Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 *  The number in each subarray should be contiguous.
 *  Return the largest sum.
 */

	public int maxTwoSubArrays (ArrayList<Integer> nums) {
		int[] left = helper(nums);
		Collections.reverse(nums);
		int[] right = helper(nums);
		
		Integer max = null;
		for (int l = 1; l <= nums.size() - 1; l++) {  // find the mid point, take global max on left and global max on right
			int r = nums.size() - l;
			if (max == null) max = left[l] + right[r];
			else max = Math.max(max, left[l] + right[r]);
		}
		return max;
	}
	

	//  or, use greedy here
	private int[] helper (List<Integer> nums) {
		int[] local = new int[nums.size() + 1];
		int[] ans = new int[nums.size() + 1];
		
		for (int i = 1; i < nums.size(); i++) {
			if (i == 1) {
				local[i] = nums.get(i-1);
				ans[i] = nums.get(i-1);
		
			} else {
				local[i] = Math.max(nums.get(i-1), local[i-1] + nums.get(i-1));
				ans[i] = Math.max(ans[i-1], local[i]);
			}
		}
		return ans;
	}
