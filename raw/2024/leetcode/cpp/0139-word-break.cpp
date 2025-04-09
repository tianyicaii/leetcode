#include <set>
#include <string>
#include <vector>

bool wordBreak(std::string s, std::vector<std::string>& wordDict) {

    std::set<std::string> d(wordDict.begin(), wordDict.end());

    int N = s.size() + 1;
    std::vector<int> dp(N + 1, false);

    for (int i = 0; i <= N; ++i) {
        if (i == 0) dp[i] = true;
        else {
            for (int j = 1; j <= i && !dp[i]; ++j) {
                std::string last = s.substr(i - j, j);
                if (d.find(last) != d.end()) {
                    dp[i] = dp[i - j];
                }
            }
        }
    }
    return dp[N];
}
