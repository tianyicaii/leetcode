// https://leetcode.com/problems/burst-balloons/


public class Solution {


	// at least, have a lookup table.

	Map<Integer, Map<Integer, Integer>> mem;
	
	public int maxCoins (int[] nums) {
		if (nums == null || nums.length == 0) return 0;  // no balloons
		mem = new HashMap<>();
		nums = addSentinal(nums);
		return helper(nums, 0, nums.length - 1);  // length has changed.
	}
	
	private int helper(int[] nums, int left, int right) {
		if (left == right - 1) return 0;  // no balloons.
		if (mem.containsKey(left) && mem.get(left).containsKey(right)) return mem.get(left).get(right);
		
		int ans = 0;
		for (int i = left + 1; i < right; i++) {
			ans = Math.max(ans, helper(nums, left, i) + nums[left] * nums[i] * nums[right] + helper(nums, i, right));
		}
		
		if (!mem.containsKey(left)) mem.put(left, new HashMap<>());
		mem.get(left).put(right, ans);
		return ans;
	}
	
	private int[] addSentinal (int[] nums) {
		int[] ans = new int[nums.length + 2];
		ans[0] = 1;
		ans[nums.length + 1] = 1;
		for (int i = 0; i < nums.length; i++) 
			ans[i + 1] = nums[i];
		return ans;
	}


	// bottom up


	public int maxCoins (int[] nums) {
		if (nums == null || nums.length == 0) return 0;  // no balloons
		nums = addSentinal(nums);
		int[][] dp = new int[nums.length + 1][nums.length];  // length of subarray, starting point of subarray
		for (int len = 3; len <= nums.length; len ++) {
			for (int left = 0; left + len <= nums.length; left++) {
				for (int i = left + 1; i < left + len - 1; i ++) {
					dp[len][left] = Math.max(dp[len][left], dp[i - left + 1][left] + dp[left + len - 1 - i + 1][i] + nums[left] * nums[i] * nums[left + len - 1]);
				}
			}
		}
		return dp[nums.length][0];
	}


}

