#include <string>
#include <vector>

std::string longestCommonPrefix(std::vector<std::string>& strs) {

    if (strs.empty()) { return ""; }

    std::string ans;
    for (int j = 0; j < strs[0].size(); j++) {
        char c = strs[0][j];
        for (int i = 1; i < strs.size(); i++) {
            if (strs[i][j] != c) { return ans; }
        }
        ans.push_back(c);
    }
    return ans;
}
