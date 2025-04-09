#include <map>
#include <string>


bool helper(const std::string & pattern, int p_idx, const std::string & s, int s_idx, std::map<char, std::string> & p_2_s, std::map<std::string, char> & s_2_p) {
    if (p_idx == pattern.size() && s_idx == s.size()) return true;
    if (p_idx == pattern.size() || s_idx == s.size()) return false;

    char p = pattern[p_idx];
    if (p_2_s.count(p)) {
        std::string str = p_2_s[p];
        if (str != s.substr(s_idx, str.size())) return false;
        else return helper(pattern, p_idx + 1, s, s_idx + str.size(), p_2_s, s_2_p);
    } else {
        for (int len = 1; len + s_idx <= s.size(); ++len) {
            std::string str = s.substr(s_idx, len);
            if (s_2_p.count(str)) continue;
            p_2_s[p] = str;
            s_2_p[str] = p;
            if (helper(pattern, p_idx + 1, s, s_idx + len, p_2_s, s_2_p)) { return true; }
            else {
                p_2_s.erase(p);
                s_2_p.erase(str);
            }
        }
    }
    return false;
}


bool wordPatternMatch(std::string pattern, std::string s) {
    std::map<char, std::string> p_2_s;
    std::map<std::string, char> s_2_p;
    return helper(pattern, 0, s, 0, p_2_s, s_2_p);
}
