#include <algorithm>
#include <climits>
#include <set>
#include <vector>


int coinChange(std::vector<int>& coins, int amount) {

    std::vector<int> dp(amount + 1, INT_MAX);
    std::set<int> co(coins.begin(), coins.end());

    for (int i = 0; i <= amount; ++i) {

        if (i == 0) { dp[i] = 0; }
        else {
            for (int c : co) {
                if (i - c >= 0 && dp[i-c] != INT_MAX) {
                    dp[i] = std::min(dp[i], dp[i-c] + 1);
                }
            }
        }
    }

    return dp[amount] == INT_MAX ? -1 : dp[amount];
}
