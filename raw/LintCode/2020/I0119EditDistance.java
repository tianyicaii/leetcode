package lintcode;

public class I0119EditDistance {
    
    public int minDistance(String word1, String word2) {

        int R = word1.length();
        int C = word2.length();

        int[][] dp = new int[R + 1][C + 1];

        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= C; j++) {

                if (i == 0 && j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    char a = word1.charAt(i-1);
                    char b = word2.charAt(j-1);
                    if (a == b) dp[i][j] = dp[i-1][j-1];
                    else {
                        dp[i][j] = 1 + dp[i-1][j-1];
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i-1][j]);
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-1]);
                    }
                }
            }
        }

        return dp[R][C];
    }
}
