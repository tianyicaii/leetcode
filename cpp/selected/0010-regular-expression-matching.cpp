#include <string>
#include <vector>


bool is_match_char(char s, char p) {
    return p == '.' || s == p;
}


bool isMatch(std::string s, std::string p) {

    std::vector<std::vector<bool>> dp(s.length() + 1, std::vector<bool>(p.length() + 1));

    for (int i = 0; i <= s.length(); i++) {
        for (int j = 0; j <= p.length(); j++) {

            if (i == 0 && j == 0) { dp[i][j] = true; }
            else if (i == 0) {
                if (p[j-1] == '*') { dp[i][j] = dp[i][j-2];}  // j >= 2
                else { dp[i][j] = false; }
            }
            else if (j == 0) { dp[i][j] = false; }
            else {
                if (p[j-1] == '*') {  // j >= 2 
                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] && is_match_char(s[i-1], p[j-2]));
                } else {
                    dp[i][j] = dp[i-1][j-1] && is_match_char(s[i-1], p[j-1]);
                }
            }
        }
    }

    return dp[s.length()][p.length()];
};
