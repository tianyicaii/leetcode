#include <map>
#include <stack>
#include <string>


std::map<char, char> parentheses = {
    {'(', ')'},
    {'[', ']'},
    {'{', '}'},
};


bool is_open(char c) {
    return c == '(' || c == '[' || c == '{';
}

bool is_close(char c) {
    return c == ')' || c == ']' || c == '}';
}

bool is_match(char x, char y) {
    auto it = parentheses.find(x);
    return it != parentheses.end() && it->second == y;
}


bool isValid(std::string s) {

    std::stack<char> opens;

    for (auto it = s.begin(); it != s.end(); ++it) {
        if (is_open(*it)) {
            opens.push(*it);
        }
        else if (is_close(*it)) {
            if (opens.empty()) { return false; }
            if (is_match(opens.top(), *it)) {
                opens.pop();
            }
            else { return false; }
        }
        else { return false; }
    }
    return opens.empty();
}
