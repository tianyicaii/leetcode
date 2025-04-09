/*

http://www.lintcode.com/en/problem/maximum-gap/

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.
Notice: You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

*/


// pigeon hole principle

	class Range {
		boolean set = false;
		int min;
		int max;
		public void add (int x) {
			if (!set) {
				min = x;
				max = x;
				set = true;
			} else {
				min = Math.min(min, x);
				max = Math.max(max, x);
			}
		}
	}
	
	public int maximumGap (int[] nums) {
		if (nums.length < 2) return 0;
		
		int max = nums[0];
		int min = nums[0];
		for (int i : nums) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		
		int range = max - min;
		if (range == 0) return 0;  // zero bucket

		int bucketSize = 0;
		int numBuckets = nums.length;
		
		// make sure the first element is in the first bucket
		// and the last element is in the last bucket
		// bucket is [ .. )
		
		if (range % (nums.length - 1) == 0) bucketSize = range / (nums.length - 1);
		else bucketSize = range / (nums.length - 1) + 1;
		
		Range[] buckets = new Range[numBuckets];
		for (int i = 0; i < numBuckets; i++) buckets[i] = new Range();
		for (int i : nums) buckets[(i - min) / bucketSize].add(i);

		int ans = 0;
		
		for (int i = 1, prev = buckets[0].max; i < buckets.length; i++) {
			if (buckets[i].set) {
				ans = Math.max(ans, buckets[i].min - prev);
				prev = buckets[i].max;
			}
		}
		return ans;
	}	
