// https://leetcode.com/problems/contains-duplicate-ii/


public class Solution {


	public boolean containsNearbyDuplicate (int[] nums, int k) {
		if (nums == null || k == 0) return false;
		Set<Integer> inWindow = new HashSet<>();
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			if (inWindow.contains(nums[right])) return true;
			inWindow.add(nums[right]);
			if (right - left == k) {
				inWindow.remove(nums[left]);
				left ++;
			}
			right ++;
		}
		return false;
	}


}

