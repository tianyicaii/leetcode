#include <algorithm>
#include <vector>

int maxProfit(std::vector<int>& prices) {

    int N = prices.size();

    std::vector<int> sell(N);
    std::vector<int> buy(N);

    for (int i = 0; i < N; ++i) {

        if (i == 0) {
            buy[i] = -prices[i];
            sell[i] = 0;
        } else if (i == 1) {
            buy[i] = std::max(-prices[i], buy[i-1]);
            sell[i] = std::max(sell[i-1], +prices[i] + buy[i]);
        } else {
            buy[i] = std::max(-prices[i] + sell[i-2], buy[i-1]);
            sell[i] = std::max(+prices[i] + buy[i], sell[i-1]);
        }
    }

    return sell[N -1];
}
