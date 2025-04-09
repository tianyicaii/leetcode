#include <algorithm>
#include <vector>

int minCost(std::vector<std::vector<int>>& costs) {

    int N = costs.size();

    std::vector<std::vector<int>> dp(N, std::vector<int>(3));

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (i == 0) {
                dp[i][j] = costs[i][j];
            } else {
                dp[i][j] = costs[i][j] + std::min(dp[i-1][(j + 1) % 3], dp[i-1][(j + 2) % 3]);
            }
        }
    }

    return std::min(dp[N-1][0], std::min(dp[N-1][1], dp[N-1][2]));
}
