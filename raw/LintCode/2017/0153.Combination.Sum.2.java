/*
 *  http://www.lintcode.com/en/problem/combination-sum-ii/
 *
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *  Each number in C may only be used once in the combination.
 *  Notice
 *      All numbers (including target) will be positive integers.
 *      Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *      The solution set must not contain duplicate combinations.
 */

// duplicates elements are allowed. each occurrence of a element can be used once.

	public List<List<Integer>> combinationSum2 (int[] candidates, int target) {
		TreeMap<Integer, Integer> input = new TreeMap<>();
		for (int i : candidates) {
			if (!input.containsKey(i)) input.put(i, 0);
			input.put(i, input.get(i) + 1);
		}
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> selection = new ArrayList<>();
		helper(ans, input, selection, target);
		return ans;
	}
	
	void helper (List<List<Integer>> ans, TreeMap<Integer, Integer> input, List<Integer> selection, int target) {  // each recursive call handles one distinct element
		if (target == 0) {
			ans.add(new ArrayList<>(selection));
			return;
		}
		if (input.isEmpty() || target < 0) return;
		
		int cnt = 0;
		int i = input.firstKey();
		int c = input.get(i);
		input.remove(i);
		
		for (int j = 0; j < c && target > 0; j++) {
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
		input.put(i, c);
	}




// primitive
	public List<List<Integer>> combinationSum2 (int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> soFar = new ArrayList<>();
		helper(ans, num, 0, soFar, target);
		return ans;
	}
	
	
	void helper (List<List<Integer>> ans, int[] candidates, int index, List<Integer> soFar, int target) {

		if (target == 0) {
			ans.add(new ArrayList<>(soFar));
			return;
		}

		if (index == candidates.length) return;
		if (target < 0) return;
		
		
		for (int i = index; i < candidates.length && target > 0; i++) {
			if (i != index && candidates[i] == candidates[i-1]) continue;  // find next unique element
			soFar.add(candidates[i]);
			helper(ans, candidates, i + 1, soFar, target - candidates[i]);
			soFar.remove(soFar.size() - 1);
		}
	}
