package lintcode;

public class I0430ScrambleStrings {
    
    public boolean isScramble(String s1, String s2) {

        int N = s1.length();
        if (s2.length() != N) return false;
        boolean[][][] dp = new boolean[N][N][N+1];

        for (int n = 1; n <= N; n++) {
            for (int i = 0; i + n <= N; i++) {
                for (int j = 0; j + n <= N; j++) {

                    if (n == 1) dp[i][j][n] = s1.charAt(i) == s2.charAt(j);
                    else {
                        for (int l = 1; l < n && !dp[i][j][n]; l++) {
                            dp[i][j][n] = (dp[i][j][l] && dp[i+l][j+l][n-l]) || (dp[i][j+n-l][l] && dp[i+l][j][n-l]);
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }
}
