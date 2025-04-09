package lintcode;

import java.util.List;

public class I0091MinimumAdjustmentCost {
    
    public int MinAdjustmentCost(List<Integer> A, int target) {

        int N = A.size();
        int[][] dp = new int[N][100];

        int i = 0;
        for (int x : A) {
            for (int j = 0; j < 100; j++) {
                if (i == 0) {
                    dp[i][j] = Math.abs(x - j);
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < 100; k++) {
                        if (Math.abs(k - j) <= target) {
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
                        }
                    }
                    dp[i][j] += Math.abs(x - j);
                }
            }
            i++;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < 100; j++) {
            ans = Math.min(ans, dp[N-1][j]);
        }
        return ans;
    }
}
