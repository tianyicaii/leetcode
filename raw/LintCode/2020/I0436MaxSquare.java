package lintcode;

public class I0436MaxSquare {
    
    public int maxSquare(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[R][C];
        int ans = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) continue;
                if (i == 0 || j == 0) dp[i][j] = matrix[i][j];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                ans = Math.max(ans, dp[i][j] * dp[i][j]);
            }
        }
        return ans;
    }
}
