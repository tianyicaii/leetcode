// https://leetcode.com/problems/sort-transformed-array/


public class Solution {


	public int[] sortTransformedArray (int[] nums, int a, int b, int c) {
		int[] ans = new int[nums.length];
		int index = (a > 0) ? nums.length - 1 : 0;
		int i = 0;
		int j = nums.length - 1;
		
		while (i <= j) {
			int x = helper(nums[i], a, b, c);
			int y = helper(nums[j], a, b, c);
			if (a > 0) {  // fill right to left
				if (x > y) {
					ans[index --] = x;
					i += 1;
				}
				else {
					ans[index --] = y;
					j -= 1;
				}
			}
			else {  // fill left to right
				if (x <= y) {
					ans[index ++] = x;
					i += 1;
				}
				else {
					ans[index ++] = y;
					j -= 1;
				}	
			}
		}
		return ans;
	}
	
	private int helper (int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}


}

