#include <string>

char findTheDifference(std::string s, std::string t) {

    int ans = 0;
    for (char c : s) {
        ans ^= c;
    }
    for (char c : t) {
        ans ^= c;
    }

    return (char)ans;
};
