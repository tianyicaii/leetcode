// https://leetcode.com/problems/missing-ranges/


public class Solution {
	

	public List<String> findMissingRanges (int[] nums, int lower, int upper) {
		List<String> ans = new ArrayList<>();
		
		int start = lower;
		for (int i : nums) {
			if (i != start) ans.add(getRange(start, i-1));
			start = i + 1;
		}
		if (start != upper + 1) ans.add(getRange(start, upper));
		return ans;
	}	
	private String getRange (int start, int end) {
		if (start == end) return "" + start;
		else              return start + "->" + end;
	}


}

