#include <string>

std::string getNext(std::string & prev) {
    std::string ans;
    auto i = prev.begin();
    while (i != prev.end()) {
        auto j = i + 1;
        while (j != prev.end() && *j == *i) ++j;
        ans.append(std::to_string(j - i));
        ans.push_back(*i);
        i = j;
    }
    return ans;
}

std::string countAndSay(int n) {
    std::string str = "1";
    for (int i = 2; i <= n; ++i) {
        str = getNext(str);
    }
    return str;
}
