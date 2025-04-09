package lintcode;

public class I0110MinimumPathSum {
    
    public int minPathSum(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;

        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j-1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i-1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[R-1][C-1];
    }
}
