#include <string>
#include <vector>

bool isScramble(std::string s1, std::string s2) {

    int N = s1.size();

    std::vector<std::vector<std::vector<int>>> dp(N+1, std::vector<std::vector<int>>(N, std::vector<int>(N, 0)));

    for (int k = 1; k <= N; ++k) {
        for (int i = 0; i + k <= N; ++i) {
            for (int j = 0; j + k <= N; ++j) {

                if (k == 1) {
                    dp[k][i][j] = (s1[i] == s2[j]);
                }
                else {
                    for (int p = 1; p < k && !dp[k][i][j]; ++p) {
                        dp[k][i][j] = (
                            (dp[p][i][j] && dp[k-p][i + p][j + p])
                            ||
                            (dp[p][i][j + k - p] && dp[k-p][i+p][j])
                        );
                    }
                }
            }
        }
    }

    return dp[N][0][0];
}
