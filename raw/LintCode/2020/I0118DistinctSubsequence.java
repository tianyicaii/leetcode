package lintcode;

public class I0118DistinctSubsequence {
    
    public int numDistinct(String S, String T) {

        int R = S.length();
        int C = T.length();

        int[][] dp = new int[R+1][C+1];

        for (int i = 0; i <= R; i++) {
            for (int j = 0; j<=C; j++) {

                if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else if (j == 0) dp[i][j] = 1;
                else {
                    char s = S.charAt(i-1);
                    char t = T.charAt(j-1);
                    if (s == t) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[R][C];
    }
}
