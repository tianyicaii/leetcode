#include <vector>

bool canWinNim(int n) {

    if (n <= 3) return true;

    std::vector<bool> dp(n + 1);

    dp[0] = false;
    dp[1] = true;
    dp[2] = true;
    dp[3] = true;

    for (int i = 4; i <= n; ++i) {
            dp[i] = (!dp[i-1]) || (!dp[i-2]) || (!dp[i-3]);
    }
    return dp[n];
}
