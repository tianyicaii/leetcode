// https://leetcode.com/problems/wiggle-sort-ii/


public class Solution {


	public void wiggleSort(int[] nums) {

		Arrays.sort(nums);
		if (nums.length <= 2) return;

		int m = (nums.length - 1) / 2;

		// worst case:
		// x + 1 small, x + y median, y large
		// x     snall, x + y median, y large

		int[] ans = new int[nums.length];
		Arrays.fill(ans, nums[m]);

		if (nums.length % 2 == 1) {
			for (int i = 0, j = nums.length - 1; nums[i] < nums[m]; i++, j -= 2) 
				ans[j] = nums[i];
			for (int i = nums.length - 1, j = 1; nums[i] > nums[m]; i--, j += 2)
				ans[j] = nums[i];
		}
		else{
			for (int i = 0, j = nums.length - 2; nums[i] < nums[m]; i++, j -= 2) 
				ans[j] = nums[i];
			for (int i = nums.length - 1, j = 1; nums[i] > nums[m]; i--, j += 2)
				ans[j] = nums[i];
		}

		// copy back
		for (int i = 0; i < nums.length; i++)
			nums[i] = ans[i];
	}


}

