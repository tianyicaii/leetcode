/*
 *  http://www.lintcode.com/en/problem/two-sum-difference-equals-to-target/
 *
 *  Given an array of integers, find two numbers that their difference equals to a target value. where index1 must be less than index2.
 *  Please note that your returned answers (both index1 and index2) are NOT zero-based.
 */

	public int[] twoSum7 (int[] numbers, int target) {
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			
			
			if (numToIndex.containsKey(numbers[i] - target)) {
				return new int[] {numToIndex.get(numbers[i] - target) + 1, i + 1};
			} else if (numToIndex.containsKey(numbers[i] + target)) {
				return new int[] {numToIndex.get(numbers[i] + target) + 1, i + 1};
			} else {
				numToIndex.put(numbers[i], i);  // y might exist
			}
			

		}
		return null;
	}
