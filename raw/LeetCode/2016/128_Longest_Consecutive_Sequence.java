// https://leetcode.com/problems/longest-consecutive-sequence/


public class Solution {
	

	public int longestConsecutive(int[] nums) {
		
		Set<Integer> seen = new HashSet<>();
		for (int i : nums) seen.add(i);
		
		int max = 0;
		for (int i : nums) {

			int down = i - 1;
			int up   = i + 1;
			
			while (seen.contains(down)) {
				seen.remove(down);
				down --;
			}
			while (seen.contains(up)) {
				seen.remove(up);
				up ++;
			}
			
			max = Math.max(max, up - down + 1 - 2);
			
		}
		return max;
	}	


}

