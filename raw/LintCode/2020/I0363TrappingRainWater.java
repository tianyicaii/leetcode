package lintcode;

import java.util.Stack;

public class I0363TrappingRainWater {

    public int trapRainWater(int[] heights) {
        if (heights.length <= 2) return 0;

        int l = 0;
        int L = heights[l];
        int r = heights.length - 1;
        int R = heights[r];
        int ans = 0;
        while (l < r - 1) {
            if (L < R) {
                ans += Math.max(0, L - heights[l+1]);
                L = Math.max(L, heights[l+1]);
                l++;
            } else {
                ans += Math.max(0, R - heights[r-1]);
                R = Math.max(R, heights[r-1]);
                r--;
            }
        }
        return ans;
    }


    public int trapRainWater_(int[] heights) {
        int N = heights.length;
        int[] L = new int[N];
        int[] R = new int[N];
        for (int i = 1; i < N; i++) L[i] = Math.max(heights[i-1], L[i-1]);
        for (int i = N-2; i >= 0; i--) R[i] = Math.max(heights[i+1], R[i+1]);
        int ans = 0;
        for (int i = 1; i < N-1; i++) {
            ans += Math.max(0, Math.min(L[i], R[i]) - heights[i]);
        }
        return ans;
    }






    private boolean lessOrEqual(int[] heights, int i, int j) { return heights[i] <= heights[j]; }

    public int trapRainWater__(int[] heights) {
        Stack<Integer> indices = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!indices.isEmpty() && lessOrEqual(heights, indices.peek(), i)) {
                int mid = indices.pop();
                if (!indices.isEmpty()) {
                    int left = indices.peek();
                    ans += (Math.min(heights[i], heights[left]) - heights[mid]) * (i - left - 1);
                }
            }
            indices.push(i);
        }
        return ans;
    }
}
