/*
 *  http://www.lintcode.com/en/problem/permutations-ii/
 *
 *  Given a list of numbers with *duplicate* number in it. Find all unique permutations.
 */

	List<Integer> sequence = new ArrayList<>();
	List<List<Integer>> output = new ArrayList<>();
	Map<Integer, Integer> input = new HashMap<>();
	
	public List<List<Integer>> permuteUnique (int[] nums) {
		for (int i : nums) {
			if (!input.containsKey(i)) input.put(i, 1);
			else input.put(i, input.get(i) + 1);
		}
		helper();
		return output;
	}

	private void helper () {  // each recursive call handles one position in the output
		if (input.isEmpty()) {
			output.add(new ArrayList<Integer>(sequence));
			return;
		} else {
			Map<Integer, Integer> copy = new HashMap<>(input);
			for (Map.Entry<Integer, Integer> e : copy.entrySet()) {  // avoid iterator's ConcurrentModificationException
				sequence.add(e.getKey());
				if (e.getValue() > 1) input.put(e.getKey(), e.getValue() - 1);
				else input.remove(e.getKey());
				helper();
				sequence.remove(sequence.size() - 1);
				input.put(e.getKey(), e.getValue());
			}
		}
	}
