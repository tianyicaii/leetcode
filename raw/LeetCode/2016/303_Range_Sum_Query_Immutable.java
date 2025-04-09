// https://leetcode.com/problems/range-sum-query-immutable/


public class NumArray {

	int[] presum;
	
	public NumArray(int[] nums) {
		presum = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			presum[i] = nums[i-1] + presum[i-1];
		}
	}

	public int sumRange(int i, int j) {
		return presum[j + 1] - presum[i];
	}

	
}

