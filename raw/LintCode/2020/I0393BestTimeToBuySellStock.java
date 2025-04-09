package lintcode;

public class I0393BestTimeToBuySellStock {

    public int maxProfit(int K, int[] prices) {
        int N = prices.length;
        K = Math.min(K, prices.length / 2);
        int[][] buy = new int[K+1][N+1];
        int[][] sell = new int[K+1][N+1];

        for (int k = 0; k <= K; k++) {
            for (int i = 0; i <= N; i++) {

                if (k == 0) ;
                else if (i == 0) ;
                else if (i == 1) buy[k][i] = - prices[i-1];
                else {
                    sell[k][i] = Math.max(sell[k][i-1], buy[k][i-1] + prices[i-1]);
                    buy[k][i] = Math.max(buy[k][i-1], sell[k-1][i-1] - prices[i-1]);
                }
            }
        }
        return sell[K][N];
    }
    
    
    public int maxProfit_(int K, int[] prices) {
        int N = prices.length;
        K = Math.min(K, prices.length);
        int[][] dp = new int[K+1][N+1];
        for (int k = 0; k <= K; k++) {
            for (int i = 0; i <= N; i++) {
                if (k == 0) ;
                else if (i == 0 || i == 1) ;
                else {
                    dp[k][i] = dp[k][i-1];
                    for (int b = 0; b < i-1; b++) {
                        dp[k][i] = Math.max(dp[k][i], (dp[k-1][b] + prices[i-1] - prices[b]));
                    }
                }
            }
        }
        return dp[K][N];
    }

}
