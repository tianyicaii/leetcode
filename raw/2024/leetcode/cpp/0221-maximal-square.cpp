#include <algorithm>
#include <vector>

int maximalSquare(std::vector<std::vector<char>>& matrix) {

    int M = matrix.size();
    int N = matrix[0].size();

    int max_seen = 0;

    std::vector<std::vector<int>> dp(M, std::vector<int>(N));
    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {


            if (i == 0 || j == 0) {
                dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
            } else {
                if (matrix[i][j] == '1') {
                    int corner = dp[i-1][j-1];
                    int up = std::min(dp[i-1][j], corner);
                    int left = std::min(dp[i][j-1], corner);
                    dp[i][j] = std::min(up, left) + 1;
                }
            }
            max_seen = std::max(max_seen, dp[i][j] * dp[i][j]);
        }
    }

    return max_seen;
}
