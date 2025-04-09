// https://leetcode.com/problems/minimum-size-subarray-sum/


public class Solution {


	public int minSubArrayLen (int s, int[] nums) {
		
		int min = 0;
		int sum = 0;
		int left = 0;
		int right = 0;
		
		while (right < nums.length) {
			sum += nums[right];
			while (sum >= s && left <= right) {  // do not cross on the last element
				if (min == 0) min = right - left + 1;
				else          min = Math.min(min, right - left + 1);
				sum -= nums[left];
				left ++;
			}
			right ++;
		}
		
		return min;
	}	


}

