/*
 *  http://www.lintcode.com/en/problem/subsets-ii/
 *
 *  Given a list of numbers that may has *duplicate* numbers, return all possible subsets
 */

	List<Integer> subset = new ArrayList<>(); 
	List<List<Integer>> output = new ArrayList<>();
	TreeMap<Integer, Integer> input = new TreeMap<>();  // input will be sorted
	
	public List<List<Integer>> subsetsWithDup (int[] nums) {
		for (int i : nums) {
			if (!input.containsKey(i)) input.put(i, 1);
			else input.put(i, input.get(i) + 1);
		}
		helper();
		return output;
	}
	
	private void helper () {  // each recursive call handles one distinct element in the input
		if (input.isEmpty()) {
			output.add(new ArrayList<Integer>(subset));  // make a copy
			return;
		} else {
			int e = input.firstKey();
			int c = input.get(e);
			input.remove(e);
			for (int i = 0; i < c; i++) {
				subset.add(e);
				helper();
			}
			for (int i = 0; i < c; i++) {
				subset.remove(subset.size() - 1);
			}
			helper();  // does not include e in this subset
			input.put(e, c);
		}
	}
