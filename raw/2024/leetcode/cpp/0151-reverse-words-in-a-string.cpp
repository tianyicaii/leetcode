#include <cctype>
#include <string>

std::string reverseWords(std::string s) {

    std::string ans;

    auto i = s.rbegin();
    while(i != s.rend()) {
        while (i != s.rend() && std::isblank(*i)) ++i;
        if (i == s.rend()) break;
        auto j = i+1;
        while (j != s.rend() && !std::isblank(*j))++j;
        if (!ans.empty()) ans.push_back(' ');
        ans.append(std::string(j.base(), i.base()));
        i = j;
    }

    return ans;
}
