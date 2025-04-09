#include <cctype>
#include <string>

int lengthOfLastWord(std::string s) {

    int ans = 0;
    auto i = s.rbegin();
    while (i != s.rend() && std::isspace(*i)) { ++i; }
    while (i != s.rend() && !std::isspace(*i)) { ++i; ++ans;}
    return ans;
}