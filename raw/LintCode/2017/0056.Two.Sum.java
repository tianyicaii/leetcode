/*
 *  http://www.lintcode.com/en/problem/two-sum/
 *
 *  Given an array of integers, find two numbers such that they add up to a specific target number.
 *  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *  Please note that your returned answers (both index1 and index2) are zero-based.
 */

	public int[] twoSum (int[] numbers, int target) {
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int j = 0; j < numbers.length; j++) {
			int y = numbers[j];
			int x = target - y;
			if (numToIndex.containsKey(x)) {
				int i = numToIndex.get(x);
				return new int[] {i, j};
			}
			numToIndex.put(y, j);  // y might exist
		}
		return null;
	}
