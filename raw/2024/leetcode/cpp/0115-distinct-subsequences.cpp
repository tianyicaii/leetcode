#include <string>
#include <vector>

int numDistinct(std::string s, std::string t) {

    int M = s.size();
    int N = t.size();
    std::vector<std::vector<unsigned long long>> dp(M + 1, std::vector<unsigned long long>(N + 1));

    for (int i = 0; i <= M; ++i) {
        for (int j = 0; j <= N; ++j) {

            if (i == 0 && j == 0) dp[i][j] = 1;
            else if (i == 0) dp[i][j] = 0;
            else if (j == 0) dp[i][j] = 1;

            else {
                if (s[i-1] == t[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    return dp[M][N];
}
