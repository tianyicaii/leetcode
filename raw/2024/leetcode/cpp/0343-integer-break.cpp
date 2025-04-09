#include <algorithm>
#include <vector>

int integerBreak(int n) {

    if (n == 2) return 1;

    std::vector<int> dp(n, 1);
    for (int i = 2; i < n; ++i) {
        dp[i] = i;
        for (int j = 2; j < i; ++j) {
            dp[i] = std::max(dp[i], dp[j] * dp[i-j]);
        }
    }
    int ans = 1;
    for (int i = 2; i < n; ++i) {
        ans = std::max(ans, dp[i] * dp[n-i]);
    }
    return ans;
}
