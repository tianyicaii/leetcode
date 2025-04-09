/*
 *  http://www.lintcode.com/en/problem/trapping-rain-water/
 *
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */


	public int trapRainWater (int[] heights) {

		int left = 0;
		int right = heights.length - 1;
		int leftMax = 0;
		int rightMax = heights.length - 1;
		int ans = 0;

		while (left < right - 1) {
			
			if (heights[leftMax] < heights[rightMax]) {
				left ++;
				if (heights[left] > heights[leftMax]) leftMax = left;  // increase left wall
				else ans += heights[leftMax] - heights[left];  // add water
				
			} else {
				right --;
				if (heights[right] > heights[rightMax]) rightMax = right;  // increase right wall
				else ans += heights[rightMax] - heights[right];  // add water
			}
		}
		
		return ans;
	}	




// for each elements, find it left bound, and right bound
	public int trapRainWater (int[] heights) {

		int n = heights.length;
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		int ans = 0;
		
		for (int i = 1; i < heights.length; i++) {
			maxLeft[i] = Math.max(maxLeft[i - 1], heights[i - 1]);
		}
		for (int i = heights.length - 2; i >= 0; i--) {
			maxRight[i] = Math.max(maxRight[i + 1], heights[i + 1]);
		}
		
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] < maxLeft[i] && heights[i] < maxRight[i])
				ans += Math.min(maxLeft[i], maxRight[i]) - heights[i];
		}
		return ans;
	}	


// given a bar, we don't know how much water it can trap until we see a larger bar
// calucate water honrizontally, lower level is trapped by smaller bars, upper level is trapped by higher bars
// stack contains bars in decreasing order

	public int trapRainWater (int[] heights) {

		Stack<Integer> left = new Stack<>();
		int ans = 0;
		
		for (int i = 0; i < heights.length; ++i) {
			
			while (!left.isEmpty() && heights[left.peek()] <= heights[i]) {  // water trapped by smaller (or equal) bars on the left is final.
				int mid = left.pop();  // add amount of water that is higher than this bar
				if (!left.isEmpty()) {
					ans += (Math.min(heights[left.peek()], heights[i]) - heights[mid]) * (i - left.peek() - 1);
				}
			}
	
			left.push(i);
		}
		return ans;
	}
