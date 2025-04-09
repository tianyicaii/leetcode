// https://leetcode.com/problems/largest-rectangle-in-histogram/


public class Solution {
	

	public int largestRectangleArea (int[] heights) {

		int max = 0;
		Deque<Integer> stack = new ArrayDeque<>();  // stack keep pillars of increasing heights, left ones can applied further

		for (int i = 0; i < heights.length; i++) {
			
			while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {  // previous high pillar cannot be applied further
				int h = heights[stack.pollLast()];
				int left = (stack.isEmpty()) ? 0 : stack.peekLast() + 1;
				max = Math.max(max, (i - left) * h);
			}
			
			stack.offerLast(i);
		}
		
		while (!stack.isEmpty()) {
			int h = heights[stack.pollLast()];
			int left = (stack.isEmpty()) ? 0 : stack.peekLast() + 1;
			max = Math.max(max, (heights.length - left) * h);  // right expand to the end
		}
		
		return max;
	}


}

