#include <vector>

int minPathSum(std::vector<std::vector<int>>& grid) {


    int m = grid.size();
    if (m == 0)  return -1;
    int n = grid.front().size();
    std::vector<std::vector<int>> dp(m, std::vector<int>(n));

    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {

            if (i == 0 && j == 0) { dp[i][j] = grid[i][j]; }
            else if (i == 0) { dp[i][j] = dp[i][j-1] + grid[i][j]; }
            else if (j == 0) { dp[i][j] = dp[i-1][j] + grid[i][j]; }
            else {
                dp[i][j] = std::min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
    }
    return dp[m-1][n-1];

}
