#include <string>

int strStr(std::string haystack, std::string needle) {

    if (haystack.size() < needle.size()) { return -1; }

    for (auto i = haystack.begin(); i <= haystack.end() - needle.size(); ++i) {
        int d = 0;
        for (auto j = needle.begin(); j != needle.end(); ++j) {
            if (*(i + d) != *j) { break; }
            d += 1;
        }
        if (d == needle.size()) { return i - haystack.begin(); }
    }
    return -1;
}
