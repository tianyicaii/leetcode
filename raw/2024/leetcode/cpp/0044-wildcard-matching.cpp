#include <string>
#include <vector>

bool isMatch(std::string s, std::string p) {


    std::vector<std::vector<bool>> dp(s.size() + 1, std::vector<bool>(p.size() + 1));

    for (int i = 0; i <= s.size(); ++i) {
        for (int j = 0; j <= p.size(); ++j) {

            if (i == 0 && j == 0) { dp[i][j] = true; }
            else if (i == 0) {
                if (p[j-1] == '*') { dp[i][j] = dp[i][j-1]; }
                else { dp[i][j] = false; }
            } else if (j == 0) { dp[i][j] = false; }
            else {
                if (p[j-1] == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    if (p[j-1] == '?') { dp[i][j] = dp[i-1][j-1]; }
                    else { dp[i][j] = ((s[i-1] == p[j-1]) && dp[i-1][j-1]); }
                }
            }
        }
    }

    return dp[s.size()][p.size()];
}
