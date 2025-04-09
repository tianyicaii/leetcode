// https://leetcode.com/problems/majority-element/


public class Solution {


	public int majorityElement(int[] nums) {
		int candidate = 0;  // dummy value
		int count     = 0;  // candidate is invalid

		for (int i = 0; i < nums.length; i++) {

			if (count == 0) {  // candidate is invalid, next one is new candidate
				candidate = nums[i];
				count     = 1;
			}

			else {
				if (candidate == nums[i]) {
					count += 1;
				}
				else {
					count -= 1;
				}
			}
		}

		return candidate;
	}


}

