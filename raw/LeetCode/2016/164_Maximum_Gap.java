// https://leetcode.com/problems/maximum-gap/


public class Solution {
	

	private class Bucket {  // each bucket contains range [min, ... , max)
		int min;
		int max;
		public Bucket (int i) {
			min = i;
			max = i;
		}
		public void add (int i) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
	}
	
	public int maximumGap(int[] nums) {
		
		if (nums == null || nums.length == 0 || nums.length == 1) return 0;
		
		int min = nums[0];
		int max = nums[0];
		for (int i : nums) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
		if (max == min) return 0;  // everything falls into one bucket.

		int bucketSize = (int) Math.ceil((double)(max - min) / (nums.length - 1));
		// max gap will be at least this large, any gap smaller than it can be ignored.
		Bucket[] buckets = new Bucket[nums.length];
		// at most one element per bucket
		
		for (int i : nums) {
			int index = (i - min) / bucketSize;
			if (buckets[index] == null)
				buckets[index] = new Bucket(i);
			buckets[index].add(i);
		}
		
		int prev = buckets[0].max;  // buckets must not null for min
		int gap = 0;
		for (int i = 0; i < nums.length; i++) {
			if (buckets[i] == null) continue;
			else {
				if (gap < buckets[i].min - prev)
					gap = buckets[i].min - prev;
				prev = buckets[i].max;
			}
		}
		
		return gap;
	}
	

}

