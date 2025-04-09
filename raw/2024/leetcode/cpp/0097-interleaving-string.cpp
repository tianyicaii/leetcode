#include <string>
#include <vector>

bool isInterleave(std::string s1, std::string s2, std::string s3) {


    int M = s1.size();
    int N = s2.size();

    if (s3.size() != M + N) return false;

    std::vector<std::vector<bool>> dp(M + 1, std::vector<bool>(N + 1));

    for (int i = 0; i <= M; ++i) {
        for (int j = 0; j <= N; ++j) {

            if (i == 0 && j == 0) dp[i][j] = true;
            else if (i == 0) {
                dp[i][j] = (s2[j-1] == s3[j-1]) && dp[i][j-1];
            } else if (j == 0) {
                dp[i][j] = (s1[i-1] == s3[i-1]) && dp[i-1][j];
            } else {
                dp[i][j] = (s1[i-1] == s3[i + j -1] && dp[i-1][j]) || (s2[j-1] == s3[i + j -1] && dp[i][j-1]);
            }
        }
    }

    return dp[M][N];
}