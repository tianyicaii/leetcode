package lintcode;

public class I0109Triangle {
    
    public int minimumTotal(int[][] triangle) {

        int R = triangle.length;
        int C = triangle[R-1].length;
        int[][] dp = new int[R][C];

        for (int i = R-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == R-1) dp[i][j] = triangle[i][j];
                else dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
