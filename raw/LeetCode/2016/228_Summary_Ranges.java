// https://leetcode.com/problems/summary-ranges/


public class Solution {


	public List<String> summaryRanges(int[] nums) {
		
		List<String> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) return ans;

		int start = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1] + 1) continue;
			else {
				ans.add(getRange(start, nums[i-1]));
				start = nums[i];
			}
		}
		ans.add(getRange(start, nums[nums.length - 1]));
		return ans;
	}

	private String getRange (int start, int end) {
		if (start == end) return start + "";
		else              return start + "->" + end;
	}


}

