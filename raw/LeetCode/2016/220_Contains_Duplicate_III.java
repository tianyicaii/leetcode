// https://leetcode.com/problems/contains-duplicate-iii/


public class Solution {


	// TreeSet, range lookup.


	public boolean containsNearbyAlmostDuplicate (int[] nums, int k, int t) {

		TreeSet<Integer> inWindow = new TreeSet<>();
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			Integer lower = inWindow.ceiling(nums[right] - t);
			Integer upper = inWindow.floor(nums[right] + t);
			if (lower != null && lower <= nums[right] ||
				upper != null && upper >= nums[right]) return true;
			inWindow.add(nums[right]);
			if (right - left == k)
				inWindow.remove(nums[left++]);
			right ++;
		}
		return false;
	}	




	private long getIndex(long val, long sz) {
		if (val >= 0) return val / sz;
		else return (val + 1) / sz - 1;
	}
	
	public boolean containsNearbyAlmostDuplicate (int[] nums, int k, int t) {
		if (t < 0) return false;
		Map<Long, Long> buckets = new HashMap<>();
		long bSz = (long) t + 1;
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			long bIdx = getIndex(nums[right], bSz);
			if (buckets.containsKey(bIdx)) return true;
			if (buckets.containsKey(bIdx - 1) && Math.abs(buckets.get(bIdx - 1) - nums[right]) <= t) return true;
			if (buckets.containsKey(bIdx + 1) && Math.abs(buckets.get(bIdx + 1) - nums[right]) <= t) return true;
			buckets.put(bIdx, (long)nums[right]);
			
			if (right - left == k) 
				buckets.remove(getIndex(nums[left ++], bSz));
			
			right ++;
		}
		return false;
	}	


}

