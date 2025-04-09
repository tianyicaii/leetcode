/*
 *  http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iv/
 *
 *  Say you have an array for which the ith element is the price of a given stock on day i.
 *  Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *  Notice
 *      You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */


// cross reference DP

// a buy action depends on previous sell action
// a sell action depends on previous buy action


	public int maxProfitQaad (int K, int[] prices) {
		if (prices.length < 2) return 0;
		K = Math.min(K, prices.length);
		int[][] buy = new int[2][prices.length];
		int[][] sell = new int[2][prices.length];

		for (int i = 0; i < K; i++) {  // number of transaction
			for (int j = 0; j < prices.length; j++) {  // length of prefix of prices
		
				
				if (i == 0) {  // base case, first transaction
					if (j == 0) {
						buy[i%2][j] = -prices[j];
						sell[i%2][j] = 0;
					} else {
						buy[i%2][j] = Math.max(buy[i%2][j-1],  - prices[j]);
						sell[i%2][j] = Math.max(sell[i%2][j-1], buy[i%2][j-1] + prices[j]);
					}
				} else {  // inductive step
					if (j == 0) {
						buy[i%2][j] = -prices[j];
						sell[i%2][j] = 0;
					} else {
						buy[i%2][j] = Math.max(buy[i%2][j-1], sell[(i-1)%2][j-1] - prices[j]);
						sell[i%2][j] = Math.max(sell[i%2][j-1], buy[i%2][j-1] + prices[j]);
					}
				}
				
			
			}
		}
		return sell[(K-1)%2][prices.length-1];
	}




// cubic running time
	public int maxProfitCube (int K, int[] prices) {
		K = Math.min(K, prices.length);
		int[][] M = new int[2][prices.length + 1];
		for (int i = 1; i <= K; i++)  // number of transaction
			for (int j = 1; j <= prices.length; j++)  // length of prefix of prices
				for (int k = j-1; k >= 0; k--)  // at day[k], buy and sell at day[j];
					M[i%2][j] = Math.max(M[i%2][j], Math.max(M[i%2][j-1], M[(i-1)%2][k] + (prices[j-1] - prices[k])));
		return M[K%2][prices.length];
	}	
