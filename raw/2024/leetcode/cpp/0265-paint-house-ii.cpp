#include <vector>

int minCostII(std::vector<std::vector<int>>& costs) {

    int N = costs.size();
    int M = costs[0].size();

    std::vector<std::vector<int>> dp(N, std::vector<int>(M));

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (i == 0) {
                dp[i][j] = costs[i][j];
            } else {
                for (int k = 1; k < M; ++k) {
                    if (k == 1) dp[i][j] = costs[i][j] + dp[i-1][(j + k) % M];
                    else dp[i][j] = std::min(dp[i][j], costs[i][j] + dp[i-1][(j + k) % M]);
                }
            }
        }
    }

    int ans = 0;
    for (int k = 0; k < M; ++k) {
        if (k == 0) ans = dp[N-1][k];
        else ans = std::min(ans, dp[N-1][k]);
    }
    return ans;
}
