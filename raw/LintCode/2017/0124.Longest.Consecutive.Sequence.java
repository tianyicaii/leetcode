/*
 *  http://www.lintcode.com/en/problem/longest-consecutive-sequence/
 *
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */


// for nums[i], we need to find how far we can go on left and right
// need to check the existence of nums[i]-1, nums[i]-2,... num[i]+1, nums[i]+2...

	public int longestConsecutive (int[] nums) {
		
		Set<Integer> s = new HashSet<>();
		for (int i : nums) s.add(i);
		
		int ans = 0;
		for (int i : nums) {
			if (s.contains(i)) {
				
				int cnt = 1;
				int prev = i-1;
				while (s.contains(prev)) {
					cnt ++;
					s.remove(prev--);
				}
				int next = i+1;
				while (s.contains(next)) {
					cnt ++;
					s.remove(next++);
				}
				
				ans = Math.max(ans, cnt);
			}
		}
		
		return ans;

	}
