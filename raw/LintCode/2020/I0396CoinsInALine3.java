package lintcode;

public class I0396CoinsInALine3 {
    

    int[] prefixSum;
    int[] values;
    
    int getSum(int i, int len) {
        return prefixSum[i+len] - prefixSum[i];
    }

    int getLeft(int i, int len) {
        return values[i];
    }

    int getRight(int i, int len) {
        return values[i + len - 1];
    }

    public boolean firstWillWin(int[] values) {

        this.values = values;
        int N = values.length;
        this.prefixSum = new int[N+1];
        int[][] dp = new int[N+1][N];

        for (int i = 1; i <= N; i++) prefixSum[i] = prefixSum[i-1] + values[i-1];
        for (int len = 1; len <= N; len++) {
            for (int i = 0; i + len <= N; i++) {

                if (len == 1) dp[len][i] = values[i];
                else {
                    int L = getLeft(i, len) + (getSum(i+1, len-1) - dp[len-1][i+1]);
                    int R = getRight(i, len) + (getSum(i, len-1) - dp[len-1][i]);
                    dp[len][i] = Math.max(L, R);
                }
            }
        }

        return dp[N][0] > getSum(0, N)/2;
    }
}
