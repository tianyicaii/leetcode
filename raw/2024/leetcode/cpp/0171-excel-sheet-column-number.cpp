#include <string>

int titleToNumber(const std::string & columnTitle) {

    int ans = 0;
    for (char c : columnTitle) {
        ans *= 26;
        ans += c - 'A' + 1;
    }
    return ans;
}
