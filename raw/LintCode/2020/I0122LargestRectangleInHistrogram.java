package lintcode;

import java.util.Stack;

public class I0122LargestRectangleInHistrogram {
    

    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            int h = (i == N) ? 0 : heights[i];
            
            while (!s.empty() && heights[s.peek()] > h) {
                int mid = s.pop();
                int left = s.empty() ? -1 : s.peek();
                ans = Math.max(ans, heights[mid] * (i - left - 1));
            }
            s.push(i);
        }
        return ans;
    }

}
