#include <map>
#include <sstream>
#include <string>
#include <vector>


bool wordPattern(std::string pattern, std::string s) {

    std::map<char, std::string> p_2_s;
    std::map<std::string, char> s_2_p;


    std::istringstream parse_p(pattern);
    std::istringstream parse_s(s);
    std::string str;
    char pat;

    std::vector<char> pats;
    std::vector<std::string> strs; 

    while (parse_p >> pat) {
        pats.push_back(pat);
    }
    while (parse_s >> str) {
        strs.push_back(str);
    }
    if (pats.size() != strs.size()) return false;

    for (int i = 0; i < pats.size(); ++i) {

        pat = pats[i];
        str = strs[i];

        if (p_2_s.count(pat)) {
            if (p_2_s[pat] != str) return false;
        } else {
            p_2_s[pat] = str;
        }
        if (s_2_p.count(str)) {
            if (s_2_p[str] != pat) return false;
        } else {
            s_2_p[str] = pat;
        }
    }

    return true;
}