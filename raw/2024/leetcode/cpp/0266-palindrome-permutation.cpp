#include <set>
#include <string>

bool canPermutePalindrome(std::string s) {

    std::set<char> cnt;
    for (char c : s) {
        if (cnt.count(c)) cnt.erase(c);
        else cnt.insert(c);
    }
    return cnt.size() == 0 || cnt.size() == 1;
}

