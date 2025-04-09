#include <string>
#include <unordered_map>

std::string minWindow(std::string s, std::string t) {

    int count = t.size();
    std::unordered_map<char, int> cnt;
    for (char c : t) {
        cnt[c] += 1;
    }

    std::string::iterator min_b = s.end();
    int min_len = -1;

    std::string::iterator left = s.begin();
    std::string::iterator right = s.begin();

    while (right != s.end()) {
        char last_c = *right++;

        if (cnt.find(last_c) == cnt.end()) { continue; }
        if (--cnt[last_c] >= 0) {
            count -=1;
        }
        if (count == 0) {
            while (count == 0) {
                char first_char = *left++;
                if (cnt.find(first_char) == cnt.end()) { continue; }
                if (++cnt[first_char] == 1) { count += 1; break; }
            }
            int len = right - left + 1;
            if (min_len == -1 || len < min_len) {
                min_len = len;
                min_b = left - 1;
            }
        }
    }

    if (min_len == -1) { return ""; } 
    return std::string(min_b, min_b + min_len);
}
