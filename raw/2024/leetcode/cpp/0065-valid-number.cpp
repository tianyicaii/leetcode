#include <cctype>
#include <string>
#include <map>


bool isNumber(std::string s) {

    std::map<int, std::map<std::string, int>> dfa = {

        // state 0
        {
            0,
            {
                {"digit", 1},
                {"sign",  2},
                {"dot",   3},
            }
        },
        // state 1
        {
            1,
            {
                {"digit", 1},
                {"dot",   4},
                {"exp",   5},
            }
        },
        // state 2
        {
            2,
            {
                {"digit", 1},
                {"dot",   3},
            }
        },
        // state 3
        {
            3,
            {
                {"digit", 4},
            }
        },
        // state 4
        {
            4,
            {
                {"digit", 4},
                {"exp",   5},
            }
        },
        // state 5
        {
            5,
            {
                {"sign",  6},
                {"digit", 7},
            }
        },
        // state 6
        {
            6,
            {
                {"digit", 7},
            }
        },
        // state 7
        {
            7,
            {
                {"digit", 7},
            }
        },
    };

    int curr_state = 0;
    for (char c : s) {
        std::string group("n/a");
        if (std::isdigit(c)) {
            group = "digit";
        } else if (c == '+' || c == '-') {
            group = "sign";
        } else if (c == 'e' || c == 'E') {
            group = "exp";
        } else if (c == '.') {
            group = "dot";
        }

        auto it = dfa[curr_state].find(group);
        if (it == dfa[curr_state].end()) { return false; }
        curr_state = it->second;
    }

    return curr_state == 1 || curr_state == 4 || curr_state == 7;

}