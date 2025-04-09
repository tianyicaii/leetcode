// https://leetcode.com/problems/combination-sum/


public class Solution {


	public List<List<Integer>> combinationSum (int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		helper(ans, candidates, target, path, 0);
		return ans;
	}
	
	private void helper (List<List<Integer>> ans, int[] candidates, int target, List<Integer> path, int index) {
		
		if (target == 0) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		if (index == candidates.length || candidates[index] > target) return;

		int nextUnique = index + 1;
		while (nextUnique < candidates.length && candidates[nextUnique] == candidates[index]) nextUnique += 1;
		
		int count = 0;
		while (target >= 0) {
			helper(ans, candidates, target, path, nextUnique);
			path.add(candidates[index]);
			count += 1;
			target -= candidates[index];
		}
	
		// restore
		target += count * candidates[index];
		while (count > 0) {
			path.remove(path.size() - 1);
			count -= 1;
		}
	}


}

