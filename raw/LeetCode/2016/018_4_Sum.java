// https://leetcode.com/problems/4sum/


public class Solution {


	public List<List<Integer>> fourSum (int[] nums, int target) {
		
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i-1]) continue;
			threeSum(ans, nums, i, target);
		}
		return ans;
	}	
	
	private void threeSum (List<List<Integer>> ans, int[] nums, int i, int target) {
		for (int j = i+1; j < nums.length - 2; j++) {
			if (j != i+1 && nums[j] == nums[j-1]) continue;
			twoSum(ans, nums, i, j, target);
		}
	}
	
	private void twoSum (List<List<Integer>> ans, int[] nums, int i, int j, int target) {
		int x = j + 1;
		int y = nums.length - 1;
		while (x < y) {
			int sum = nums[i] + nums[j] + nums[x] + nums[y];
			if (sum == target) {
				List<Integer> quadruple = new ArrayList<>();
				quadruple.add(nums[i]);
				quadruple.add(nums[j]);
				quadruple.add(nums[x]);
				quadruple.add(nums[y]);
				ans.add(quadruple);
				x++;
				y--;
				while (x < y && nums[x] == nums[x-1]) x++;
				while (x < y && nums[y] == nums[y+1]) y--;
			}
			else if (sum > target) y--;
			else                   x++;
		}
	}
	

}

