// https://leetcode.com/problems/3sum-smaller/


public class Solution {


	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i + 2 <= nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					count += k - j;
					j++;
				}
				else k--;
			} 
		}
		return count;
	}


}

