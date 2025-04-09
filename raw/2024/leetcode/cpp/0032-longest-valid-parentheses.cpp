#include <algorithm>
#include <string>
#include <vector>

int longestValidParentheses(const std::string & s) {
    int max_len = 0;
    std::vector<int> dp(s.length() + 1);
    for (int i = 2; i <= s.length(); ++i) {
        if (s[i-1] == '(') { continue; }
        if (s[i-2] == '(') {
            dp[i] = dp[i-2] + 2;
        } else {

            if (dp[i-1] == i-1 || dp[i-1] == 0) {
                continue;
            }
            char left_unmatched = s[i-1 - dp[i-1] - 1];
            if (left_unmatched == ')') {
                continue;
            }
            dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
        }

        max_len = std::max(max_len, dp[i]);
    }
    return max_len;

}
