import java.util.*;

public class Solution {


	
	public List<String> findMissingRanges (int[] nums, int lower, int upper) {
		List<String> ans = new ArrayList<String>();
		if (nums.length == 0) {
			ans.add(helper(lower, upper));
			return ans;
		}
		if (nums[0] != lower) {
			ans.add(helper(lower, nums[0] - 1));
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) continue;
			else if (nums[i] != nums[i - 1] + 1) {
				ans.add(helper(nums[i - 1] + 1, nums[i] - 1));
			} else {
				;  //  nums[i] == nums[i - 1] + 1
			}
		}
		if (nums[nums.length - 1] != upper) {
			ans.add(helper(nums[nums.length - 1] + 1, upper));
		}
		return ans;
	}

	String helper (int left, int right) {
		if (left == right) return "" + left;
		else return "" + left + "->" + right;
	}

}
