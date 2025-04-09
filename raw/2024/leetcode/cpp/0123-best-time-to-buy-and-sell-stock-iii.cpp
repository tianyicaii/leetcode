#include <algorithm>
#include <vector>

int maxProfit(std::vector<int>& prices) {

    int M = 2;
    int N = prices.size();
    std::vector<std::vector<int>> buy(M, std::vector<int>(N));
    std::vector<std::vector<int>> sell(M, std::vector<int>(N));

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {

            if (i == 0 && j == 0) {

                buy[i][j] = -prices[j];
                sell[i][j] = 0;

            } else if (i == 0) {

                buy[i][j] = std::max(-prices[j], buy[i][j-1]);
                sell[i][j] = std::max(sell[i][j-1], prices[j] + buy[i][j-1]);

            } else if (j == 0) {

                buy[i][j] = -prices[j];
                sell[i][j] = 0;

            } else {

                buy[i][j] = std::max(-prices[j] + sell[i-1][j-1], buy[i][j-1]);
                sell[i][j] = std::max(sell[i][j-1], prices[j] + buy[i][j-1]);

            }
        }
    }

    return sell[M-1][N-1];
}

