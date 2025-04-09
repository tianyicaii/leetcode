// https://leetcode.com/problems/combination-sum-iii/


public class Solution {


	public List<List<Integer>> combinationSum3 (int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(ans, path, 1, k, n);
		return ans;
	}
	private void dfs (List<List<Integer>> ans, List<Integer> path, int num, int k, int n) {  // each call choose one number
		if (k == 0 && n == 0) {
			ans.add(new ArrayList<>(path));
			return;
		}
		if (k == 0 || n == 0) return;
		
		for (int i = num; i <= 9 && i <= n; i++) {
			path.add(i);
			dfs(ans, path, i + 1, k - 1, n - i);
			path.remove(path.size() - 1);
		}
	}


}

