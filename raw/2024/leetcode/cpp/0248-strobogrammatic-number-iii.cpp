#include <string>
#include <vector>
#include <map>


std::map<char, char> pairs = {
    {'0', '0'},
    {'1', '1'},
    {'6', '9'},
    {'8', '8'},
    {'9', '6'},
};


std::vector<std::string> gen(int len) {
    if (len == 0) return {""};
    if (len == 1) return {"0", "1", "8"};
    std::vector<std::string> ans;
    std::vector<std::string> sub = gen(len - 2);
    for (const auto & s : sub) {
        for (const auto & i : pairs) {
            ans.push_back(i.first + s + i.second);
        }
    }
    return ans;
}


int strobogrammaticInRange(std::string low, std::string high) {

    int cnt = 0;
    for (int i = low.size(); i <= high.size(); ++i) {

        std::vector<std::string> ans = gen(i);
        for (const auto & s : ans) {
            if (s.length() > 1 && s[0] == '0') continue;
            if (i == low.size() && s < low) continue;
            if (i == high.size() && s > high) continue;
            cnt += 1;
        }
    }
    return cnt;
}
