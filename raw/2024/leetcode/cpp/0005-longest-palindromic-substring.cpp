#include <string>

int max_p_len(std::string::iterator b, std::string::iterator e, std::string::iterator sub_b, std::string::iterator sub_e) {

    while (true) {

        if (*sub_b != *(sub_e - 1)) {
            return sub_e - sub_b - 2;
        }
        if (sub_b == b || sub_e == e) {
            return sub_e - sub_b;
        }
        --sub_b;
        ++sub_e;
    }
}

std::string longestPalindrome(std::string s) {

    if (s.length() == 0) {
        return "";
    }

    auto max_b = s.begin();
    auto max_len = 0;

    if (s.length() >= 1) {
        for (auto it = s.begin(); it != s.end(); it++) {
            auto cur_len = max_p_len(s.begin(), s.end(), it, it + 1);
            if (cur_len > max_len) {
                max_len = cur_len;
                max_b = it - cur_len / 2;
            }
        }
    }
    if (s.length() >= 2) {
        for (auto it = s.begin(); it != s.end() - 1; it++) {
            auto cur_len = max_p_len(s.begin(), s.end(), it, it + 2);
            if (cur_len > max_len) {
                max_len = cur_len;
                max_b = it - (cur_len / 2 - 1);
            }
        }
    }

    return std::string(max_b, max_b + max_len);
}
