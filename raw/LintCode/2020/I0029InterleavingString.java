package lintcode;

public class I0029InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;

        int R = s1.length() + 1;
        int C = s2.length() + 1;
        boolean[][] dp = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[i][j-1];
                else if (j == 0) dp[i][j] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][j];
                else dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])
                                || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
            }
        }

        return dp[R-1][C-1];
    }
}
