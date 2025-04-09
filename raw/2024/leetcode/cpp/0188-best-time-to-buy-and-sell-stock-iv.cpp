#include <vector>

int maxProfit(int k, std::vector<int>& prices) {

    int N = prices.size();
    std::vector<std::vector<int>> buy(k, std::vector<int>(N));
    std::vector<std::vector<int>> sell(k, std::vector<int>(N));

    for (int i = 0; i < k; ++i) {
        for (int j = 0; j < N; ++j) {

            if (i == 0 && j == 0) {
                buy[i][j] = -prices[j];
                sell[i][j] = prices[j] + buy[i][j];  // 0
            } else if (i == 0) {
                buy[i][j] = std::max(buy[i][j-1], -prices[j]);
                sell[i][j] = std::max(sell[i][j-1], prices[j] + buy[i][j]);
            } else if (j == 0) {
                buy[i][j] = -prices[j];
                sell[i][j] = prices[j] + buy[i][j];  // 0
            } else {
                buy[i][j] = std::max(buy[i][j-1], -prices[j] + sell[i-1][j]);
                sell[i][j] = std::max(sell[i][j-1], prices[j] + buy[i][j]);
            }
        }
    }

    return sell[k-1][N-1];
}
