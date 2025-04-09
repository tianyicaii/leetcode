#include <map>
#include <string>
#include <vector>

class Solution {

public:

std::vector<std::string> ans;
std::string input;
std::string path;

std::map<int, std::vector<char>> d2l = {
    {'2', {'a', 'b', 'c'}},
    {'3', {'d', 'e', 'f'}},
    {'4', {'g', 'h', 'i'}},
    {'5', {'j', 'k', 'l'}},
    {'6', {'m', 'n', 'o'}},
    {'7', {'p', 'q', 'r', 's'}},
    {'8', {'t', 'u', 'v'}},
    {'9', {'w', 'x', 'y', 'z'}},
};

void gen(std::string::iterator curr) {
    if (curr == input.end()) {
        ans.push_back(path);
        return;
    }
    char d = *curr;
    auto it = d2l.find(d);
    for (auto c : it->second) {
        path.push_back(c);
        gen(curr + 1);
        path.pop_back();
    }
}

std::vector<std::string> letterCombinations(std::string digits) {
    if (digits.empty()) { return {}; }
    ans.clear();
    input = digits;
    path.clear();
    gen(input.begin());
    return ans;
}

};
