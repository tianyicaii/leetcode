#include <cstddef>
#include <string>
#include <utility>


std::pair<std::string::iterator, size_t>
max_pal(
    std::string::iterator b,
    std::string::iterator e,
    std::string::iterator sub_b,
    std::string::iterator sub_e) {

    while (true) {
        if (*sub_b != *(sub_e - 1)) {
            return {sub_b + 1, sub_e - sub_b - 2};
        }
        if (sub_b == b || sub_e == e) {
            return {sub_b, sub_e - sub_b};
        }
        --sub_b;
        ++sub_e;
    }
}


std::string longestPalindrome(std::string s) {

    if (s.length() <= 1) {
        return s;
    }

    std::pair<std::string::iterator, size_t> max_found = {s.end(), 0};

    // odd len
    for (auto it = s.begin(); it != s.end(); ++it) {
        auto found = max_pal(s.begin(), s.end(), it, it + 1);
        if (found.second > max_found.second) {
            max_found = found;
        }
    }

    // even len
    for (auto it = s.begin(); it != s.end() - 1; ++it) {
        auto found = max_pal(s.begin(), s.end(), it, it + 2);
        if (found.second > max_found.second) {
            max_found = found;
        }
    }

    return std::string(max_found.first, max_found.first + max_found.second);
}
