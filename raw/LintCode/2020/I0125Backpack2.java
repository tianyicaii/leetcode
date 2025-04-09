package lintcode;

public class I0125Backpack2 {
    
    public int backPackII(int m, int[] A, int[] V) {

        int n = A.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {  // capacity
            for (int j = 0; j <= n; j++) {  // item

                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    int a = A[j-1];
                    int v = V[j-1];
                    if (a > i) dp[i][j] = dp[i][j-1];
                    else dp[i][j] = Math.max(dp[i][j-1], v + dp[i-a][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
