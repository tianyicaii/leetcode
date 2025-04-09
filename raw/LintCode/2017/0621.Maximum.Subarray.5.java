/*
 *  http://www.lintcode.com/en/problem/maximum-subarray-v/
 *
 *  Given an integer arrays, find a contiguous subarray which has the largest sum and length should be between k1 and k2 (include k1 and k2).
 *  Return the largest sum, return 0 if there are fewer than k1 elements in the array.
 */

	public int maxSubarray5 (int[] nums, int k1, int k2) {

		int[] prefix = new int[nums.length + 1];
		Integer max = null;
		TreeMap<Integer, Integer> sumToLength = new TreeMap<>();

		for (int i = 1; i <= nums.length; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
			
			if (i < k1) {
				continue;
			} else if (i == k1) {
				max = prefix[i];
				sumToLength.put(0, 0);
				continue;
			} else {
				if (i > k1) {
					sumToLength.put(prefix[i - k1], i - k1);  // for prefix with same sum, overwrite with the larger one
				}
				if (i > k2) {
					while (sumToLength.firstEntry().getValue() < i - k2) {  // eliminate minimum prefix that are too small, (further than k2)
						sumToLength.pollFirstEntry();
					}
				}
				int min = sumToLength.firstEntry().getKey();  // get the mininum prefix that lands in k2 boundary
				max = Math.max(max, prefix[i] - min);				
			}
			
		}
		return max == null ? 0 : max;
	}




// linear
	public int maxSubarray5 (int[] nums, int k1, int k2) {

		int[] prefix = new int[nums.length + 1];
		Integer max = null;
		Deque<Integer> min = new ArrayDeque<>();  // left to right on deque is smaller sum to larger sum prefix

		for (int i = 1; i <= nums.length; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
			
			if (i < k1) {
				continue;
			} else if (i == k1) {
				max = prefix[i];
				min.offerLast(0);
				continue;
			} else {
				if (i > k1) {
					while (!min.isEmpty() && prefix[min.peekLast()] >= prefix[i - k1]) min.pollLast();  // longer prefix with smaller sum can eliminate shorter prefix with larger sum
					min.offerLast(i-k1);
				}
				if (i > k2) {
					if (min.peekFirst() < i - k2) min.pollFirst();  // delete minimum prefix that too further back
				}
				
				max = Math.max(max, prefix[i] - prefix[min.peekFirst()]);  // first element on the left is the minimum prefix within k2 boundary
			}
			
		}
		return max == null ? 0 : max;
	}
