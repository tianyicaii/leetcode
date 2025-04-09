#include <algorithm>
#include <map>
#include <string>

int lengthOfLongestSubstringKDistinct(std::string s, int k) {

    if (k < 1) return 0;

    int ans = 0;
    int i = 0;
    int j = 0;

    std::map<char, int> cnt;

    while (j < s.size()) {
        cnt[s[j]] += 1;
        ++j;
        while (cnt.size() > k) {
            if (--cnt[s[i]] == 0) {
                cnt.erase(s[i]);
            }
            ++i;
        }
        ans = std::max(ans, j - i);
    }
    return ans;
}
