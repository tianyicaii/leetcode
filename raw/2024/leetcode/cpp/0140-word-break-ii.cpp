#include <set>
#include <string>
#include <vector>


void find(std::vector<std::string> & ans, std::vector<std::string> & path, const std::string & s, int i, std::set<std::string> d) {
    if (i == s.length()) {
        std::string a = path[0];
        for (int p = 1; p < path.size(); ++p) {
            a += ' ' + path[p];
        }
        ans.push_back(std::move(a));
        return;
    }

    for (int len = 0; i + len <= s.size(); ++len) {
        std::string seg = s.substr(i, len);
        if (d.find(seg) != d.end()) {
            path.push_back(seg);
            find(ans, path, s, i + len, d);
            path.pop_back();
        }
    }
}

std::vector<std::string> wordBreak(std::string s, std::vector<std::string>& wordDict) {

    std::vector<std::string> ans;
    std::vector<std::string> path;
    std::set<std::string> d(wordDict.begin(), wordDict.end());
    find(ans, path, s, 0, d);
    return ans;
}
