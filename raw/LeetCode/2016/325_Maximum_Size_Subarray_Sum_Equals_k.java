// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/


public class Solution {


	public int maxSubArrayLen (int[] nums, int k) {
		int max = 0;

		Map<Integer, Integer> sum2Idx = new HashMap<>();
		sum2Idx.put(0, -1);

		for (int i = 0, total = 0; i < nums.length; i++) {
			total += nums[i];
			int left = total - k;
			if (sum2Idx.containsKey(left)) 
				max = Math.max(max, i - sum2Idx.get(left));
			if (!sum2Idx.containsKey(total)) 
				sum2Idx.put(total, i);
		}

		return max;
	}


}

