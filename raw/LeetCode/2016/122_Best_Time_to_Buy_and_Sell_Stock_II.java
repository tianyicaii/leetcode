// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


public class Solution {
	

/*	
	public int maxProfit (int[] prices) {
		if (prices.length < 2) return 0;
		return helperSell(prices, prices.length - 1);
	}
	private int helperSell (int[] prices, int index) {
		if (index == 0) return 0;
		return Math.max(helperSell(prices, index - 1),
						prices[index] + helperBuy(prices, index - 1));
	}
	private int helperBuy (int[] prices, int index) {
		if (index == 0) return -prices[0];
		return Math.max(helperBuy(prices, index - 1),
						-prices[index] + helperSell(prices, index - 1));
	}
*/
	
	public int maxProfit (int[] prices) {
		if (prices.length < 2) return 0;
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				buy[i] = -prices[i];
				sell[i] = 0;
			}
			else {
				buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
				sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
			}
		}
		return sell[prices.length];
	}


}

