// https://leetcode.com/problems/permutations/


public class Solution {


	public List<List<Integer>> permute (int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		helper(ans, nums, used, new ArrayList<Integer>(), 0);
		return ans;
	}
	
	private void helper (List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> path, int index) {
		if (index == nums.length) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			path.add(nums[i]);
			used[i] = true;
			helper(ans, nums, used, path, index + 1);
			used[i] = false;
			path.remove(path.size() - 1);
		}
	}


}

