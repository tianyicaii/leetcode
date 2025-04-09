// https://leetcode.com/problems/two-sum/

import java.util.Map;
import java.util.HashMap;

public class L0001_Two_Sum {

	public int[] twoSum (int[] nums, int target) {

		Map<Integer, Integer> value2Index = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (value2Index.containsKey(x)) {
				return new int[] { value2Index.get(x), i };
			}
			value2Index.put(nums[i], i);
		}
		return null;
	}
}
