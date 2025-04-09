#include <algorithm>
#include <vector>

int calculateMinimumHP(std::vector<std::vector<int>>& dungeon) {

    int M = dungeon.size();
    int N = dungeon[0].size();

    std::vector<std::vector<int>> dp(M, std::vector<int>(N));

    for (int i = M-1; i >= 0; --i) {
        for (int j = N-1; j >= 0; --j) {
            dp[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
            int require = 0;
            int left = dp[i][j] + dungeon[i][j];
            if (i == M-1 && j == N-1) { ; }
            else if (i == M-1) {
                if (left < dp[i][j+1]) {
                    require = dp[i][j+1] - left;
                }
            }
            else if (j == N-1) {
                if (left < dp[i+1][j]) {
                    require = dp[i+1][j] - left;
                }
            }
            else {
                int choose = std::min(dp[i+1][j], dp[i][j+1]);
                if (left < choose) {
                    require = choose - left;
                }
            }

            dp[i][j] += require;
        }
    }

    return dp[0][0];
}
