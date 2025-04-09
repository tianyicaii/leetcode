#include <algorithm>
#include <map>
#include <string>

int lengthOfLongestSubstringTwoDistinct(const std::string & s) {


    std::map<char, int> cnt;

    int max_len = 0;
    auto i = s.begin();
    auto j = s.begin();

    while (j != s.end()) {
        ++cnt[*j];
        while (cnt.size() > 2) {
            --cnt[*i];
            if (!cnt[*i]) { cnt.erase(*i); }
            ++i;
        }
        max_len = std::max(max_len, (int)(j - i + 1));
        ++j;
    }

    return max_len;
}