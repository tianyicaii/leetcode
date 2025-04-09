package lintcode;

public class I0149BestTimeToBuyStock {
    
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minPrice = prices[0];
        for (int i : prices) {
            maxprofit = Math.max(maxprofit, i - minPrice);
            minPrice = Math.min(minPrice, i);
        }
        return maxprofit;
    }
}
