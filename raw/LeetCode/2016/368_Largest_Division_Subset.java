// https://leetcode.com/problems/largest-divisible-subset/


public class Solution {


	// we want to add num[i] to the largest possible subset before/after it
	
	public List<Integer> largestDivisibleSubset (int[] nums) {
		
		if (nums == null || nums.length == 0) return new ArrayList<>();
		
		
		int[] sz = new int[nums.length];
		Arrays.fill(sz, 1);
		int[] id = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			id[i] = i;
		
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] % nums[i] == 0 && sz[i] < sz[j] + 1) {
					sz[i] = sz[j] + 1;
					id[i] = j;
				}
			}
		}
		
		int start = 0;
		int maxSz = 1;
		for (int i = 0; i < nums.length; i++) {
			if (sz[i] > maxSz) {
				start = i;
				maxSz = sz[i];
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		ans.add(nums[start]);
		for (int i = start; i != id[i]; i = id[i])
			ans.add(nums[id[i]]);
		
		return ans;
	}


}

