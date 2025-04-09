package lintcode;

public class I0440Backpack3 {
    

    public int backPackIII(int[] A, int[] V, int m) {
        int N = A.length;
        int[][] dp = new int[N+1][m+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= m; j++) {

                if (j == 0 || i == 0) dp[i][j] = 0;
                else if (j < A[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-A[i-1]]+V[i-1]);
            }
        }

        return dp[N][m];
    }
}
