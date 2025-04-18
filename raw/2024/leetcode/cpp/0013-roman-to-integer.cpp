#include <map>
#include <string>

int romanToInt(std::string s) {

    std::map<char, int> digits {
        {'M', 1000},
        {'D',  500},
        {'C',  100},
        {'L',   50},
        {'X',   10},
        {'V',    5},
        {'I',    1},
    };

    int prev = 0;
    int ans = 0;

    for (auto it = s.rbegin(); it != s.rend(); it++) {
        int d = digits.find(*it)->second;
        if (d < prev) {
            ans -= d;
        } else {
            ans += d;
        }
        prev = d;
    }
    return ans;
}