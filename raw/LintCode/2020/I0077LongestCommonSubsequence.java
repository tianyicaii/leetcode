package lintcode;

public class I0077LongestCommonSubsequence {
    
    public int longestCommonSubsequence(String A, String B) {
        int R = A.length();
        int C = B.length();
        if (R == 0 || C == 0) return 0;

        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                char a = A.charAt(i);
                char b = B.charAt(j);

                if (i == 0 && j == 0) dp[i][j] = (a == b) ? 1 : 0;
                else if (i == 0) dp[i][j] = (a == b) ? 1 : dp[i][j-1];
                else if (j == 0) dp[i][j] = (a == b) ? 1 : dp[i-1][j];
                else dp[i][j] = (a == b) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[R-1][C-1];
    }
}
