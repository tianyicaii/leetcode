package lintcode;

public class I0092Backpack {
    
    public int backPack(int m, int[] A) {

        int n = A.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int x = A[i-1];
                if (x > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-x] + x, dp[i-1][j]);
            }
        }

        return dp[n][m];
    }
}
