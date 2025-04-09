/*
 *  http://www.lintcode.com/en/problem/permutations/
 *
 *  Given a list of *distinct* numbers, return all possible permutations.
 */

// backtrace: for each position [1 .. n] choose one element from input

	List<Integer> sequence = new ArrayList<>();
	List<List<Integer>> output = new ArrayList<>();
	Set<Integer> input = new HashSet<>();
	
	public List<List<Integer>> permute (int[] nums) {
		for (int i : nums) input.add(i);
		helper();
		return output;
	}
	
	private void helper () {  // each recursive call handles one position in the output
		if (input.isEmpty()) {
			output.add(new ArrayList<Integer>(sequence));
			return;
		} else {
			Set<Integer> copy = new HashSet<>(input);  // avoid iterator's ConcurrentModificationException
			for (int e : copy) {
				sequence.add(e);
				input.remove(e);
				helper();
				sequence.remove(sequence.size() - 1);
				input.add(e);
			}
		}
	}




// enumeration: find next permutation in lexicographical order

	public ArrayList<ArrayList<Integer>> permute (ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (nums == null) return ans;
		Collections.sort(nums);
		do {
			ans.add(new ArrayList<>(nums));  // smallest permutation
		} while (getNext(nums));
		return ans;
	}
	
	// curr permutation: 12349876
	//                      i   j
	// next permutation: 12364789
    
	private boolean getNext (ArrayList<Integer> nums) {
		int n = nums.size();
		for (int i = nums.size() - 2; i >= 0; i--) {
			for (int j = nums.size() - 1; j > i; j--) {
				if (nums.get(i) < nums.get(j)) {
					swap(nums, i, j);
					reverse(nums, i + 1, n - 1);
					return true;
				}
			}
		}
		return false;  // reversely sorted, no next permutation.
	}

	private void swap (ArrayList<Integer> nums, int i, int j) {
		int tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}

	private void reverse (ArrayList<Integer> nums, int left, int right) {
		while (left < right) swap(nums, left++, right--);
	}
