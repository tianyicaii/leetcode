/*
 *  http://www.lintcode.com/en/problem/maximal-rectangle/#
 *
 *  Given a 2D boolean matrix filled with False and True, find the largest rectangle containing all True and return its area.
 */

	public int maximalRectangle (boolean[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int[][] heights = new int[matrix.length][matrix[0].length];
		int ans = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (matrix[i][j])
					if (i == 0) heights[i][j] = 1;
					else heights[i][j] = heights[i-1][j] + 1;
				else heights[i][j] = 0;
			}
			
			ans = Math.max(maximalRectangleInHistrogram(heights[i]), ans);
		}
		return ans;
	}
	
	int maximalRectangleInHistrogram (int[] heights) {
		Stack<Integer> s = new Stack<>();
		int ans = 0;
		for (int i = 0; i <= heights.length; i++) {
			int newHeight = (i == heights.length) ? -1 : heights[i];

			if (s.isEmpty() || newHeight >= heights[s.peek()]) s.push(i);
			else {
				while (!s.isEmpty() && newHeight < heights[s.peek()]) {
					int h = heights[s.pop()];
					int l = (s.isEmpty()) ? -1 : s.peek();
					ans = Math.max(ans, (i - l - 1) * h);
				}
				s.push(i);
			}

		}
		return ans;
	}




//  for each array location, find the tallest rectangle it belongs

// distinction from max square
// for an element matrix[i][j], we cannot find the largest up left rectangle including this point from sub-problems
// overral optimal is not derived from optimal solution of sub-problems (for areas)

	public int maximalRectangle (boolean[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;
		
		
		int[][] height = new int[matrix.length][matrix[0].length];
		int[][] left = new int[matrix.length][matrix[0].length];
		int[][] right = new int[matrix.length][matrix[0].length];
		
		
		for (int i = 0; i < matrix.length; i++) {
			
			
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j])
					if (i == 0) height[i][j] = 1;
					else height[i][j] = height[i - 1][j] + 1;
				else height[i][j] = 0;
			}

			
			for (int j = 0, L = 0; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					L ++;
					if (height[i][j] == 1) left[i][j] = L;  // not connected with above
					else left[i][j] = Math.min(left[i - 1][j], L);  // represent the rectangle which goes as high as possible
				} else left[i][j] = L = 0;
			}
			
			
			for (int j = matrix[0].length - 1, R = 0; j >= 0; j--) {
				if (matrix[i][j]) {
					R ++;
					if (height[i][j] == 1) right[i][j] = R;  // not connected with above
					else right[i][j] = Math.min(right[i - 1][j], R);  // connected with above
				} else right[i][j] = R = 0;
			}
			
			
		}
		
		
		int ans = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				ans = Math.max(ans, (left[i][j] + right[i][j] - 1) * height[i][j]);
			}
		}
		return ans;
	}
