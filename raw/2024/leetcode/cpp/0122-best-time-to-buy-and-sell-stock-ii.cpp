#include <vector>

int maxProfit(std::vector<int>& prices) {

    int N = prices.size();

    int ans = 0;
    for (int i = 1; i < N; ++i) {
        int delta = prices[i] - prices[i-1];
        if (delta > 0) ans += delta;
    }
    return ans;
}
