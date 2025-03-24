#include <cctype>
#include <climits>
#include <string>


class DFA {

private:

    int sign = 1;
    void (DFA::*state)(char c) = &DFA::read_whitespaces;

    bool is_overflow(int d) {
        if (ans > INT_MAX / 10) { return true; }
        if (ans < INT_MIN / 10) { return true; }
        if (ans == INT_MAX / 10 && d >= INT_MAX % 10) { return true; }
        if (ans == INT_MIN / 10 && d <= INT_MIN % 10) { return true; }
        return false;
    }

    void read_whitespaces(char c) {
        if (std::isspace(c)) { return; }
        if (c == '+') { sign =  1; state = &DFA::read_digit; return; }
        if (c == '-') { sign = -1; state = &DFA::read_digit; return; }
        if (c >= '0' && c <= '9') { ans = c - '0'; state = &DFA::read_digit; return; }
        state = &DFA::done;
    }

    void read_digit(char c) {
        if (c < '0' || c > '9') { state = &DFA::done; return; }
        int d = c - '0';
        d = sign * d;
        if (is_overflow(d)) {
            if (sign > 0) { ans = INT_MAX; }
            else { ans = INT_MIN; }
            return;
        }
        ans = ans * 10 + d;
    }

    void done(char c) { return; }

public:

    int ans = 0;

    void process(char c) {
        (this->*state)(c);
    }
};


int myAtoi(std::string s) {
    DFA dfa;
    for (char c : s) {
        dfa.process(c);
    }
    return dfa.ans;
}
