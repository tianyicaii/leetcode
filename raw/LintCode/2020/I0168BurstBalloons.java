package lintcode;

public class I0168BurstBalloons {
    

    int[] nums;
    int N;

    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;

        this.nums = nums;
        this.N = nums.length;

        int[][] dp = new int[N][N + 1];

        for (int j = 1; j <= N; j++) {  // interval length
            for (int i = 0; i + j <= N; i++) {  // starting index

                if (j == 1) dp[i][j] = get(i-1) * get(i) * get(i+1);
                else {
                    for (int k = i; k < i + j; k++) {  // last balloon to burst
                        int last = get(i-1) * get(k) * get(i + j);
                        if (k == i) dp[i][j] = last + dp[i+1][j-1];
                        else if (k == i + j - 1) dp[i][j] = Math.max(dp[i][j], last + dp[i][j-1]);
                        else dp[i][j] = Math.max(dp[i][j], last + dp[i][k-i] + dp[k+1][i + j - k - 1]);
                    }
                }

            }
        }

        return dp[0][N];
    }

    private int get(int i) {
        if (i == -1 || i == N) return 1;
        return nums[i];
    }
}
