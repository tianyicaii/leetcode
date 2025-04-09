// https://leetcode.com/problems/sliding-window-maximum/


public class Solution {


	public int[] maxSlidingWindow (int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) return new int[] {};
		k = (k > nums.length) ? nums.length : k;

		int[] ans = new int[nums.length - k + 1];
		int i = 0;
		
		Deque<Integer> indices = new ArrayDeque<>();
		for (int left = 0, right = 0; right < nums.length; right ++) {
			int v = nums[right];
			
			// swallow left
			while (!indices.isEmpty() && nums[indices.peekLast()] <= v)
				indices.pollLast();
			indices.offerLast(right);
			
			// get max
			if (right - left + 1 == k) {  // window is full
				int maxIdx = indices.peekFirst();
				ans[i++] = nums[maxIdx];  // max in window
				if (maxIdx == left)
					indices.pollFirst();
				left ++;  // move window
			}
		}
		
		return ans;
	}


}

