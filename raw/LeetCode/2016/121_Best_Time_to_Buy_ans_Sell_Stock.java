// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


public class Solution {
	

/*
	public int maxProfit (int[] prices) {
		if (prices.length < 2) return 0;
		return helperSell(prices, prices.length - 1);
	}	
	
	public int helperBuy (int[] prices, int index) {
		if (index == 0) return - prices[0];
		else return Math.max(- prices[index], // buy on this day
							 helperBuy(prices, index - 1));  // push forward
	}
	
	public int helperSell (int[] prices, int index) {
		if (index == 1) return prices[1] - prices[0];
		else return Math.max(helperSell(prices, index - 1),   // push forward
							 helperBuy(prices, index - 1) + prices[index]);  // sell on this day
	}
*/
	
	public int maxProfit (int[] prices) {
		
		if (prices.length < 2) return 0;  // at least two prices to constitute a transaction
		
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];  // cross reference DP
		
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) { 
				buy[i] = -prices[i];
				// cannot sell on day[0];
			}
			else if (i == 1) {
				buy[i] = Math.max(-prices[0], -prices[1]);  // less loss on buy
				sell[i] = prices[1] - prices[0];  // first possible transaction
			}
			else {
				buy[i] = Math.max(buy[i-1], -prices[i]);  // buy today or push forward
				sell[i] = Math.max(prices[i] + buy[i-1], sell[i-1]);
			}
		}
		
		return Math.max(0, sell[prices.length - 1]);  // last element is a sell, 0 for leetcode
	}


}

