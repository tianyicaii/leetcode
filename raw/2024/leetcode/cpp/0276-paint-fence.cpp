#include <vector>

int numWays(int n, int k) {

    std::vector<int> dp(n);

    for (int i = 0; i < n; ++i) {
        if (i == 0) dp[i] = k;
        else if (i == 1) dp[i] = k * k;
        else {
            dp[i] = dp[i-2] * (k-1) + dp[i-1] * (k-1);
        } 
    }
    return dp[n-1];
}
