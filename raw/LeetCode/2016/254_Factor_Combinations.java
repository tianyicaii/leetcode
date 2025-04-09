// https://leetcode.com/problems/factor-combinations/


public class Solution {


	public List<List<Integer>> getFactors (int n) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		for (int i = 2; i < n; i ++) {
			if (n % i != 0) continue;
			path.add(i);
			helper(ans, path, i, n/i);
			path.remove(path.size() - 1);
		}
		return ans;
	}
	
	private void helper (List<List<Integer>> ans, List<Integer> path, int factor, int n) {
		if (n == 1) {
			ans.add(new ArrayList<>(path));
			return;  // all divided up
		}
		if (factor > n) return;  // failed factorization
		for (int i = factor; i <= n; i++) {
			if (n % i != 0) continue;
			path.add(i);
			helper(ans, path, i, n / i);
			path.remove(path.size() - 1);
		}
	}


}

