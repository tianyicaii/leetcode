#include <map>
#include <vector>
#include <string>

std::string get_key(const std::string & s) {
    if (s.empty()) return s;
    if (s[0] == 'a') return s;
    int shift = s[0] - 'a';
    std::string key;
    for (char c : s) {
        char c2 = c - shift;
        if (c2 < 'a') c2 += 26;
        key.push_back(c2);
    }
    return key;
}

std::vector<std::vector<std::string>> groupStrings(std::vector<std::string>& strings) {

    std::map<std::string, std::vector<std::string>> groups;

    for (const auto & s : strings) {
        groups[get_key(s)].push_back(s);
    }

    std::vector<std::vector<std::string>> ans;
    for (const auto & i : groups) {
        ans.push_back(i.second);
    }
    return ans;
}
