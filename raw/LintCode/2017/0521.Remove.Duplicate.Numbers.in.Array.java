/*
 *  http://www.lintcode.com/en/problem/remove-duplicate-numbers-in-array/
 *
 *  Given an array of integers, remove the duplicate numbers in it.
 *  You should:
 *      1. Do it in place in the array.
 *      2. Move the unique numbers to the front of the array.
 *      3. Return the total number of the unique numbers.
 */

	public int deduplication (int[] nums) {
		if (nums.length == 0) return 0;
		Arrays.sort(nums);
		int lastUnique = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (lastUnique == -1 || nums[i] != nums[lastUnique]) nums[++lastUnique] = nums[i];
		}
		
		return lastUnique + 1;
	}


//  what set is used for
	public int deduplication (int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int i : nums) {
			s.add(i);
		}
		int index = 0;
		for (int i : s) {
			nums[index++] = i;
		}
		return index;
	}
