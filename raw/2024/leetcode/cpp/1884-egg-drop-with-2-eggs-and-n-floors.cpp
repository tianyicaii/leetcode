#include <algorithm>
#include <vector>

int twoEggDrop(int n) {

    std::vector<int> dp(n + 1);

    for (int i = 1; i <= n; ++i) {
        if (i == 1) dp[i] = 1;
        else {
            for (int j = 1; j <= i; ++j) {
                if (j == 1) dp[i] = i;
                else {
                    dp[i] = std::min(dp[i], std::max(j, dp[i - j] + 1));
                }
            }
        }
    }
    return dp[n];
}
