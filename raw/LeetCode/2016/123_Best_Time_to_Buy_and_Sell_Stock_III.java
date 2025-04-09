// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


public class Solution {
	

	public int maxProfit(int[] prices) {
		
		if (prices.length < 2) return 0;
		
		int[][] buy = new int[2][prices.length];
		int[][] sell = new int[2][prices.length];
		
		for (int i = 0; i < prices.length; i++) {  // transaction once
			if (i == 0) {
				buy[0][i] = -prices[0];
				sell[0][i] = 0;  // no transaction
			}
			else {
				buy[0][i] = Math.max(buy[0][i-1], 0 - prices[i]);
				sell[0][i] = Math.max(sell[0][i-1], buy[0][i-1] + prices[i]);
			}
		}
		for (int i = 0; i < prices.length; i++) {  // transaction twice
			if (i == 0) {
				buy[1][i] = -prices[0];
				sell[1][i] = 0;  // no transaction				
			}
			else {
				buy[1][i] = Math.max(buy[1][i-1], sell[0][i-1] - prices[i]);
				sell[1][i] = Math.max(sell[1][i-1], buy[1][i-1] + prices[i]);
			}			
		}
		
		return sell[1][prices.length - 1];
	}	


}

