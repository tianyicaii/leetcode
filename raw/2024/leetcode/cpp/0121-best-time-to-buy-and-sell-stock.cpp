#include <algorithm>
#include <vector>

int maxProfit(std::vector<int>& prices) {

    int N = prices.size();
    if (N < 2) return 0;

    std::vector<int> min_buy(N);

    for (int i = 0; i < N; ++i) {
        if (i == 0) min_buy[i] = prices[i];
        else min_buy[i] = std::min(prices[i], min_buy[i-1]);
    }

    int ans = prices[1] - prices[0];
    for (int i = 2; i < N; ++i) {
        ans = std::max(ans, prices[i] - min_buy[i-1]);
    }

    if (ans < 0) return 0;
    return ans;
}