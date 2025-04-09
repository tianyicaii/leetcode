#include <map>
#include <set>
#include <string>


bool isIsomorphic(std::string s, std::string t) {

    if (s.size() != t.size()) return false;

    std::set<char> seen;
    std::map<char, char> m;

    for (int i = 0; i < s.size(); ++i) {
        char S = s[i];
        char T = t[i];

        if (seen.count(T) && m.count(S) && m[S] == T) continue;
        if (m.count(S)) return false;
        if (seen.count(T)) return false;

        seen.insert(T);
        m[S] = T;
    }
    return true;
}
