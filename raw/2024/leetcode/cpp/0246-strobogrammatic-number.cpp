#include <map>
#include <string>


std::map<char, char> pairs = {
    {'0', '0'},
    {'1', '1'},
    {'6', '9'},
    {'8', '8'},
    {'9', '6'},
};


bool isStrobogrammatic(const std::string & num) {

    for (auto i = num.begin(), j = num.end() - 1; i <= j; ++i, --j) {
        if (i == j) {
            if (!pairs.count(*i) || pairs[*i] != *i) return false;
        } else {
            if (!pairs.count(*i) || pairs[*i] != *j) return false;
        }
    }
    return true;
}
