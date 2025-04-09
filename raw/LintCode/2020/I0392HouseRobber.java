package lintcode;

public class I0392HouseRobber {
    
    public long houseRobber(int[] A) {
        int N = A.length;
        long[] dp = new long[N+1];

        for (int i = 1; i <= N; i++) {
            if (i == 1) dp[i] = A[i-1];
            else dp[i] = Math.max((A[i-1] + dp[i-2]), dp[i-1]);
        }

        return dp[N];
    }
}
