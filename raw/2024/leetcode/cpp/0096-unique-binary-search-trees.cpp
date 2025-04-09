#include <vector>

int numTrees(int n) {

    std::vector<int> dp(n+1);

    for (int i = 0; i <= n; ++i) {
        if (i == 0) dp[i] = 1;
        else {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
    }

    return dp[n];
}