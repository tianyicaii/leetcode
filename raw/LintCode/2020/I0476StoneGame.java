package lintcode;

public class I0476StoneGame {
    
    public int stoneGame(int[] A) {
        int N = A.length;
        if (N == 0) return 0;
        int[] prefixSum = new int[N+1];
        for (int len = 1; len <= N; len++) prefixSum[len] = prefixSum[len-1] + A[len-1];
        int[][] dp = new int[N+1][N];
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i+len <= N; i++) {
                dp[len][i] = Integer.MAX_VALUE;
                for (int left = 1; left < len; left++) {
                    dp[len][i] = Math.min(dp[len][i], dp[left][i] + dp[len-left][i+left] + prefixSum[i+len] - prefixSum[i]);
                }
            }
        }
        return dp[N][0];
    }
}
