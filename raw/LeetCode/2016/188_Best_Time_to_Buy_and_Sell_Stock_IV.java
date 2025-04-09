// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


public class Solution {


	public int maxProfit (int k, int[] prices) {
		
		
		if (prices.length < 2 || k < 1) return 0;  // no transactions
		if (k > prices.length / 2) return maxProfitInfinity(prices);  // at most n / 2 effective transactions
		
		int[][] buy  = new int[k][prices.length];
		int[][] sell = new int[k][prices.length];
		
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < prices.length; j++) {
				
				
				if (i == 0) {  // first transaction
					if (j == 0) {
						 buy[i][j] = - prices[j];
						sell[i][j] = 0;  // at least we earn 0, not negative.
					}
					else {
						 buy[i][j] = Math.max( buy[i][j-1],             - prices[j]);  // either buy today or some time before today
						sell[i][j] = Math.max(sell[i][j-1], buy[i][j-1] + prices[j]);  // either sell today, or some time earlier
					}
				}
				
				
				
				else {  // can have previous transaction
					if (j == 0) {
						 buy[i][j] = - prices[j];
						sell[i][j] = 0;
					}
					else {
						 buy[i][j] = Math.max( buy[i][j-1], sell[i-1][j - 1] - prices[j]);  // last sell
						sell[i][j] = Math.max(sell[i][j-1],    buy[i][j - 1] + prices[j]);  // this buy
					}
				}
				
				
			}
		}
		
		return sell[k-1][prices.length - 1];
	}
	

	public int maxProfitInfinity (int[] prices) {
		
		
		int[] buy  = new int[prices.length];
		int[] sell = new int[prices.length];

		
		for (int j = 0; j < prices.length; j++) {
						
			if (j == 0) {
				 buy[j] = - prices[j];
				sell[j] = 0;  // at least we earn 0, not negative.
			}
			else {
				 buy[j] = Math.max( buy[j-1], sell[j-1] - prices[j]);  // either buy today or some time before today
				sell[j] = Math.max(sell[j-1],  buy[j-1] + prices[j]);  // either sell today, or some time earlier
			}
		}
		
		return sell[prices.length - 1];
	}


}

