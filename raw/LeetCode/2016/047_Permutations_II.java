// https://leetcode.com/problems/permutations-ii/


public class Solution {



	public List<List<Integer>> permuteUnique (int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		helper(ans, nums, used, new ArrayList<Integer>(), 0);
		return ans;
	}
	
	private void helper (List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> path, int index) {
		if (index == nums.length) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		Integer prev = null;
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			if (prev != null && nums[i] == prev) continue;
			used[i] = true;
			path.add(nums[i]);
			helper(ans, nums, used, path, index + 1);
			used[i] = false;
			path.remove(path.size() - 1);
			prev = nums[i];
		}
	}


}

