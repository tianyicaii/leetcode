#include <string>
#include <vector>

int minDistance(std::string word1, std::string word2) {

    int m = word1.size();
    int n = word2.size();

    std::vector<std::vector<int>> dp(std::vector<std::vector<int>>(m + 1, std::vector<int>(n + 1)));

    for (int i = 0; i <= m; ++i) {
        for (int j = 0; j <= n; ++j) {

            if (i == 0 && j == 0) { dp[i][j] = 0; } 
            else if (i == 0) { dp[i][j] = dp[i][j-1] + 1; }
            else if (j == 0) { dp[i][j] = dp[i-1][j] + 1; }
            else {
                if (word1[i-1] == word2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    dp[i][j] = std::min(dp[i][j], dp[i-1][j] + 1);
                    dp[i][j] = std::min(dp[i][j], dp[i][j-1] + 1);
                }
            }
        }
    }

    return dp[m][n];
}
