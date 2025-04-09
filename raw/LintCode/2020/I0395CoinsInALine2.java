package lintcode;

public class I0395CoinsInALine2 {

    int N;
    int[] values;

    private int getFromRight(int i) {
        return values[N-1-i];
    }

    public boolean firstWillWin(int[] values) {
        this.N = values.length;
        this.values = values;
        int[] dp = new int[N+1];
        int[] suffixSum = new int[N+1];

        for (int i = 1; i <= N; i++) suffixSum[i] = suffixSum[i-1] + getFromRight(i-1);
        for (int i = 1; i <= N; i++) {
            if (i == 1 || i == 2) dp[i] = dp[i-1] + getFromRight(i-1);
            else {
                int getOne = getFromRight(i-1) + (suffixSum[i-1] - dp[i-1]);
                int getTwo = getFromRight(i-1) + getFromRight(i-2) + (suffixSum[i-2] - dp[i-2]);
                dp[i] = Math.max(getOne, getTwo);
            }
        }
        return dp[N] > suffixSum[N]/2;
    }
}
