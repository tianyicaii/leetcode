/*
 *  http://www.lintcode.com/en/problem/subsets/#
 *
 *  Given a set of *distinct* integers, return all possible subsets.
 */

	List<Integer> subset = new ArrayList<>();
	List<List<Integer>> output = new ArrayList<>();
	TreeSet<Integer> input = new TreeSet<>();  // input needs be sorted
	
	public List<List<Integer>> subsets (int[] nums) {
		for (int i : nums) input.add(i);
		helper();
		return output;
	}
	
	private void helper () {  // each recursive call handles one element in the input
		if (input.isEmpty()) {
			output.add(new ArrayList<Integer>(subset));
			return;
		} else {
			int e = input.first();
			input.remove(e);
			subset.add(e);
			helper();
			subset.remove(subset.size() - 1);
			helper();
			input.add(e);
		}
	}
