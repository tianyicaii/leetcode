#include <string>
#include <vector>

int minCut(std::string s) {

    int N = s.size();
    std::vector<std::vector<bool>> is_pal(N + 1, std::vector<bool>(N, false));

    for (int len = 0; len <= N; ++len) {
        for (int i = 0; i + len <= N; ++i) {
            if (len == 0 || len == 1) is_pal[len][i] = true;
            else is_pal[len][i] = s[i] == s[i + len - 1] && is_pal[len-2][i + 1];
        }
    }

    std::vector<int> dp(N + 1, -1);

    for (int e = 0; e <= N; ++e) {
        if (is_pal[e][0]) dp[e] = 0;
        else {
            for (int len = 1; len < e; ++len) {
                if (is_pal[len][e-len]) {
                    if (dp[e] == -1) dp[e] = 1 + dp[e-len];
                    else dp[e] = std::min(dp[e], 1 + dp[e - len]);
                }
            }
        }
    }

    return dp[N];
}
