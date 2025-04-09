#include <map>
#include <string>

bool isAnagram(std::string s, std::string t) {

    if (s.size() != t.size()) return false;

    std::map<char, int> cnt;
    for (char c : s) {
        cnt[c] += 1;
    }
    for (char c : t) {
        auto it = cnt.find(c);
        if (it == cnt.end()) return false;
        it->second -= 1;
        if (!it->second) cnt.erase(it);
    }
    return true;
}
