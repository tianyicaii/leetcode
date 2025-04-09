package lintcode;

public class I0079LongestCommonSubstring {
    
    public int longestCommonSubstring(String A, String B) {

        int R = A.length();
        int C = B.length();
        if (R == 0 || C == 0) return 0;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                char a = A.charAt(i);
                char b = B.charAt(j);

                if (i == 0 || j == 0) dp[i][j] = (a == b) ? 1 : 0;
                else dp[i][j] = (a == b) ? 1 + dp[i-1][j-1] : 0;
            }
        }

        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
