// https://leetcode.com/problems/combination-sum-ii/


public class Solution {


	public List<List<Integer>> combinationSum2 (int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		helper(ans, candidates, target, new ArrayList<Integer>(), 0);
		return ans;
	}
	
	private void helper (List<List<Integer>> ans, int[] candidates, int target, List<Integer> path, int index) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		if (index == candidates.length || candidates[index] > target) return;
		
		for (int i = index; i < candidates.length; i++) {
			if (i != index && candidates[i] == candidates[i-1]) continue;
			path.add(candidates[i]);
			helper(ans, candidates, target - candidates[i], path, i + 1);
			path.remove(path.size() - 1);
		}
	}


}

