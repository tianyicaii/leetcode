#include <algorithm>
#include <string>
#include <set>


int lengthOfLongestSubstring(const std::string & s) {

    int ans = 0;
    std::set<char> window;

    for (auto left = s.begin(), right = s.begin(); right != s.end(); ++right) {
        while (window.count(*right)) {
            window.erase(*left);
            ++left;
        }
        window.insert(*right);
        ans = std::max(ans, int(right - left + 1));
    }

    return ans;
}
