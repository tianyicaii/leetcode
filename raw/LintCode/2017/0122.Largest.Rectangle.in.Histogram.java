/*
 *  http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 *
 *  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 *  find the area of largest rectangle in the histogram.
 */


	public int largestRectangleArea (int[] heights) {
		
		Stack<Integer> left = new Stack<>();
		int ans = 0;
		
		for (int i = 0; i <= heights.length; i++) {
			int newHeight = (i == heights.length) ? -1 : heights[i];  // will pop all remainings on stack
			
			
			while (!left.isEmpty() &&  heights[left.peek()] > newHeight) {
				int h = heights[left.pop()];
				int l = (left.empty()) ? -1 : left.peek();
				ans = Math.max(ans, h * (i - l - 1));
			}
			
			
			left.push(i);  // cannot process this bar until sees a smaller one
			               // this bar extent to the left to the one before it on the stack
			               // this bar extent to the right until the bar that pops it. 
		}

		return ans;
	}
