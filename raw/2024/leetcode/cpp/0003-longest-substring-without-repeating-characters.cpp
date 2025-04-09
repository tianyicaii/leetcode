#include <algorithm>
#include <string>
#include <unordered_set>

int lengthOfLongestSubstring(const std::string & s) {

    int ret = 0;
    std::unordered_set<char> window;
    auto left = s.begin();
    auto right = s.begin();

    while (right != s.end()) {
        while (window.find(*right) != window.end()) {
            window.erase(*left);
            left ++;
        }
        window.insert(*right);
        ret = std::max(ret, int(right - left + 1));
        right ++;
    }
    return ret;
}
