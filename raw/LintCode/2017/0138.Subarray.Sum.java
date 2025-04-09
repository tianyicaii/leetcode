/*
 *  http://www.lintcode.com/en/problem/subarray-sum/
 *
 *  Given an integer array, find a subarray where the sum of numbers is zero.
 *  Your code should return the index of the first number and the index of the last number.
 */


// find two prefixes for which the sums are equals

	public List<Integer> subarraySum (int[] nums) {
		HashMap<Integer, Integer> lengthFromBeginning = new HashMap<>();
		int[] prefixSums = new int[nums.length + 1];
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i <= nums.length; i++) {
			if (i == 0) {
				prefixSums[i] = 0;
				lengthFromBeginning.put(0, 0);
			} else {
				prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
				if (lengthFromBeginning.containsKey(prefixSums[i])) {
					ans.add(lengthFromBeginning.get(prefixSums[i]));
					ans.add(i - 1);
					return ans;
				} else {
					lengthFromBeginning.put(prefixSums[i], i);
				}
			}
		}
		
		throw new RuntimeException("no solution");
	}
