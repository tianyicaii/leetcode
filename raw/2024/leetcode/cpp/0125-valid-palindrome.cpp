#include <cctype>
#include <string>

bool isPalindrome(const std::string & s) {

    auto b = s.begin();
    auto e = s.end();

    while (b < e) {
        while (b < e && !std::isalnum(*b)) ++b;
        while (b < e && !std::isalnum(*(e-1))) --e;
        if (b == e) break;
        if (std::tolower(*b) == std::tolower(*(e-1))) { ++b; --e; }
        else return false;
    }
    return true;
}