// https://leetcode.com/problems/3sum-closest/


public class Solution {



	public int threeSumClosest (int[] nums, int target) {
		
		int n = nums.length;
		if (n < 3) throw new IllegalArgumentException("length < 3");
		
		int ans = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		
		for (int i = 0; i < n - 2; i++) {
			int sum = nums[i] + twoSumClosest(nums, target - nums[i], i);
			if (Math.abs(sum - target) < Math.abs(ans - target)) ans = sum;
		}
		
		return ans;
	}
	
	// precondition: at least two element left
	private int twoSumClosest (int[] nums, int target, int i) {
		
		int j = i + 1;
		int k = nums.length - 1;
		int ans = nums[j] + nums[k];
		
		while (j < k) {
			int sum = nums[j] + nums[k];
			if (Math.abs(sum - target) < Math.abs(ans - target)) ans = sum;
			if (sum == target) return target;
			if (sum >  target) k--;
			else               j++;
		}
		return ans;
	}


}

