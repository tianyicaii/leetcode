// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/


public class Solution {
	

	public int maxProfit (int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int n = prices.length;

		int[] buy  = new int[n];
		int[] sell = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				buy[i] = - prices[i];
				sell[i] = 0;
			}
			else if (i == 1) {
				buy[i] = Math.max(buy[i-1], 0 - prices[i]);
				sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
			}
			else {
				buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);  // cool down
				sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
			}
		}
		
		return sell[n - 1];
	}


}

