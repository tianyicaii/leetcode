package lintcode;

public class I0394CoinsInALine {
    
    public boolean firstWillWin(int n) {
        boolean[] dp = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) dp[i] = true;
            else dp[i] = !dp[i-1] || !dp[i-2];
        }
        return dp[n];
    }
}
