#include <algorithm>
#include <map>
#include <string>
#include <vector>

std::string get_key(std::string str) {
    std::sort(str.begin(), str.end());
    return str;
}

std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {

    std::vector<std::vector<std::string>> ans;
    std::map<std::string, std::vector<std::string>> m;

    for (const std::string & s : strs) {
        m[get_key(s)].push_back(s);
    }
    for (const auto i : m) {
        ans.push_back(i.second);
    }
    return ans;
}
