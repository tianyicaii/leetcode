// https://leetcode.com/problems/subsets/


public class Solution {
	

	public List<List<Integer>> subsets (int[] nums) {
		
		List<List<Integer>> ans = new ArrayList<>();
		
		int count = 1 << nums.length;
		for (int i = 0; i < count; i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if (((i >> j) & 1) == 1)
					subset.add(nums[j]);
			}
			ans.add(subset);
		}
		return ans;
	}	


}

