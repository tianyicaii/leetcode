// https://leetcode.com/problems/3sum/


public class Solution {


	public List<List<Integer>> threeSum (int[] nums) {
		
		List<List<Integer>> ans = new ArrayList<>();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i-1]) continue;  // skip dups
			twoSum(ans, nums, i);
		}
		
		return ans;
	}
	
	private void twoSum (List<List<Integer>> ans, int[] nums, int i) {
	
		int target = 0 - nums[i];
		int j = i+1;
		int k = nums.length - 1;
	
		while (j < k) {
			int sum = nums[j] + nums[k];
			if (sum == target) {
				List<Integer> triple = new ArrayList<>();
				triple.add(nums[i]);
				triple.add(nums[j]);
				triple.add(nums[k]);
				ans.add(triple);
				j++;
				k--;
				
				while (j < k && nums[j] == nums[j-1]) j++;  // skip dups
				while (j < k && nums[k] == nums[k+1]) k--;
			}
			else if (sum > target) { k--; }
			else                   { j++; }
		}
	}


}

