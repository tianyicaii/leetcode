#include <string>

bool is_pal(std::string s) {
    for (int i = 0, j = s.size() - 1; i < j; ++i, --j) {
        if (s[i] != s[j]) return false;
    }
    return true;
}

long long MOD = 1e9 + 7;
long long BASE = 29;

std::string shortestPalindrome(std::string s) {

    if (s.empty()) return "";

    long long max_pos = 0;
    long long f_hash = 0;
    long long r_hash = 0;
    long long power = 1;

    for(int i = 0; i <= s.size(); ++i) {
        f_hash *= BASE;
        f_hash %= MOD;
        f_hash += (s[i] - 'a');
        f_hash %= MOD;

        r_hash += (s[i] - 'a') * power;
        r_hash %= MOD;
        power *= BASE;
        power %= MOD;

        if (f_hash == r_hash) {
            // if (is_pal(std::string(s.begin(), s.begin() + i + 1))) {
                max_pos = i;
            // } 
        }
    }
    return
        std::string(s.rbegin(), s.rend() - max_pos - 1) + 
        std::string(s.begin(), s.begin() + max_pos + 1) +
        std::string(s.begin() + max_pos + 1, s.end());

}
