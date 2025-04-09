#include <vector>
#include <string>


bool is_pal(std::string & s, int i, int len) {
    int j = i + len - 1;
    while (i < j) {
        if (s[i++] != s[j--]) return false;
    }
    return true;
}

void bt(std::vector<std::vector<std::string>> & ans, std::vector<std::string> & path, std::string & s, int i) {
    if (i == s.size()) {
        ans.push_back(path);
    } else {
        for (int len = 1; i + len <= s.size(); ++len) {
            if (is_pal(s, i, len)) {
                path.push_back(s.substr(i, len));
                bt(ans, path, s, i + len);
                path.pop_back();
            }
        }
    }
}


std::vector<std::vector<std::string>> partition(std::string s) {

    std::vector<std::vector<std::string>> ans;
    std::vector<std::string> path;
    bt(ans, path, s, 0);
    return ans;
}
