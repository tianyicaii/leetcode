#include <string>
#include <vector>


int numDecodings(std::string s) {

    if (s.empty()) return 0;

    std::vector<int> dp(s.size() + 1);

    for (int i = 0; i <= s.size(); ++i) {
        if (i == 0) { dp[i] = 1; }
        else if (i == 1) {
            if (s[0] == '0') dp[1] = 0;
            else dp[1] = 1;
        }
        else {
            int v1 = s[i-2] - '0';
            int v2 = s[i-1] - '0';

            if (v1 == 0) {
                if (v2 == 0) dp[i] = 0;
                else dp[i] = dp[i-1];
            } else if (v1 == 1) {
                if (v2 == 0) dp[i] = dp[i-2];
                else dp[i] = dp[i-1] + dp[i-2];
            } else if (v1 == 2) {
                if (v2 == 0) dp[i] = dp[i-2];
                else if (v2 > 6) dp[i] = dp[i-1];
                else dp[i] = dp[i-1] + dp[i-2];
            } else {
                if (v2 == 0) dp[i] = 0;
                else dp[i] = dp[i-1];
            }
        }
    }

    return dp[s.size()];
}

