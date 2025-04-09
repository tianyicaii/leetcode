/*
 *  http://www.lintcode.com/en/problem/combination-sum/
 *
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *  The same repeated number may be chosen from C unlimited number of times.
 *  Notice
 *      All numbers (including target) will be positive integers.
 *      Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *      The solution set must not contain duplicate combinations.
 */


// try all possibilities

	public List<List<Integer>> combinationSum (int[] candidates, int target) {
		TreeSet<Integer> input = new TreeSet<>();
		for (int i : candidates) input.add(i);
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> selection = new ArrayList<>();
		helper(ans, input, selection, target);
		return ans;
	}
	
	void helper (List<List<Integer>> ans, TreeSet<Integer> input, List<Integer> selection, int target) {  // each recursive call handle one elemnts from input
		if (target == 0) {
			ans.add(new ArrayList<>(selection));
			return;
		}
		if (input.isEmpty() || target < 0) return;
		
		int cnt = 0;
		int i = input.pollFirst();
		while (target > 0) {
			selection.add(i);
			cnt += 1;
			target -= i;
			helper(ans, input, selection, target);
		}
		while (cnt-- > 0) {
			selection.remove(selection.size() - 1);
			target += i;
		}
	
		helper(ans, input, selection, target);  // zero time
		input.add(i);
	}
