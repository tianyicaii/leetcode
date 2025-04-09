package lintcode;

import java.util.Stack;

public class I0510MaxRectangle {
    

    public int maximalRectangle(boolean[][] matrix) {
        int N = matrix.length;
        if (N == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i == 0) heights[j] = matrix[i][j] ? 1 : 0;
                else heights[j] = (matrix[i][j]) ? 1 + heights[j] : 0;
            }
            ans = Math.max(ans, maxRectangleInHistrogram(heights));
        }
        return ans;
    }

    private int get(int[] heights, int i) {
        if (i == heights.length) return 0;
        return heights[i];
    }

    private int maxRectangleInHistrogram(int[] heights) {
        Stack<Integer> left = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = get(heights, i);
            while (!left.isEmpty() && get(heights, left.peek()) > h) {
                int m = left.pop();
                int l = left.isEmpty() ? -1 : left.peek();
                ans = Math.max(ans, get(heights, m) * (i - l - 1));
            }
            left.push(i);
        }
        return ans;
    }









    public int maximalRectangle_(boolean[][] matrix) {
        int R = matrix.length;
        if (R == 0) return 0;
        int C = matrix[0].length;
        if (C == 0) return 0;

        int[][] left = new int[R][C];
        int[][] right = new int[R][C];
        int[][] up = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j]) {
                    if (i == 0) up[i][j] = 1;
                    else up[i][j] = 1 + up[i-1][j];
                }
            }
            for (int j = 0, l = 0; j < C; j++) {
                if (matrix[i][j]) {
                    ++l;
                    if (up[i][j] == 1) left[i][j] = l;
                    else left[i][j] = Math.min(l, left[i-1][j]);
                } else { l = 0; }
            }
            for (int j = C-1, r = 0; j >= 0; j--) {
                if (matrix[i][j]) {
                    ++r;
                    if (up[i][j] == 1) right[i][j] = r;
                    else right[i][j] = Math.min(r, right[i-1][j]);
                } else { r = 0; }
            }
        }


        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans = Math.max(ans, (left[i][j] + right[i][j] - 1) * up[i][j]);
            }
        }

        return ans;
    }

}
