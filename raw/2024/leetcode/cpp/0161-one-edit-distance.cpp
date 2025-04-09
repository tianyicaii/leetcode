#include <string>
#include <vector>

bool isOneEditDistance(std::string s, std::string t) {

    int M = s.size();
    int N = t.size();

    std::vector<std::vector<int>> dp(M + 1, std::vector<int>(N + 1));
    for (int i = 0; i <= M; ++i) {
        for (int j = 0; j <= N; ++j) {
            if (i == 0 && j == 0) dp[i][j] = 0;
            else if (i == 0) dp[i][j] = j;
            else if (j == 0) dp[i][j] = i;
            else {
                if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + std::min(dp[i-1][j-1], std::min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
    }
    return dp[M][N] == 1;
}
