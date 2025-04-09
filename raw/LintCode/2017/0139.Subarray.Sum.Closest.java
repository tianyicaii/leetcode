/*
 *  http://www.lintcode.com/en/problem/subarray-sum-closest/
 *
 *  Given an integer array, find a subarray with sum closest to zero.
 *  Return the indexes of the first number and last number.
 */

	public int[] subarraySumClosest (int[] nums) {
		if (nums == null || nums.length == 0) return new int[] {};
		
		TreeMap<Integer, Integer> prefixSumToLength = new TreeMap<>();
		prefixSumToLength.put(0, 0);
		
		for (int i = 1, sum = 0; i <= nums.length; i++) {
			sum += nums[i-1];
			if (prefixSumToLength.containsKey(sum)) {  // exactly zero, need to check it here otherwise it will be overwriten.
				return new int[] {prefixSumToLength.get(sum), i-1};
			} else {
				prefixSumToLength.put(sum, i);
			}
		}
		
		// find an adjacent pair with minimum gap
		ArrayList<Integer> sums = new ArrayList<>();  // traversal all the adjacent key pairs
		for (int k : prefixSumToLength.keySet()) sums.add(k);
		int min = sums.get(1) - sums.get(0);
		int index = 0;  // index and index + 1
		for (int i = 1; i < sums.size() - 1; i++) {
			int gap = sums.get(i + 1) - sums.get(i);
			if (gap < min) {
				min = gap;
				index = i;
			}
		}
		
		
		return new int[] {
				Math.min(prefixSumToLength.get(sums.get(index)), prefixSumToLength.get(sums.get(index + 1))),  // not necessarily which index is in front
				Math.max(prefixSumToLength.get(sums.get(index)), prefixSumToLength.get(sums.get(index + 1))) - 1
		};

	}
