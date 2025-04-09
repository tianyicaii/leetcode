#include <cctype>
#include <deque>
#include <string>


int i = 0;
std::string expr;

void skip_space() {
    while (std::isspace(expr[i])) ++i;
}


int read_int() {
    skip_space();
    int x = 0;
    while (true) {
        char c = expr[i];
        if (c >= '0' && c <= '9') {
            x *= 10;
            x += c - '0';
            ++i;
        } else {
            break;
        }
    }
    return x;
}

char read_op() {
    skip_space();
    return expr[i++];
}


int calculate(std::string s) {

    i = 0;
    expr = s;
    int x = read_int();

    std::deque<int> pm;


    while (i < expr.size()) {

        char op = read_op();
        int y = read_int();

        if (op == '+') {
            pm.push_back(x);
            pm.push_back(1);
            x = y;
        } else if (op == '-') {
            pm.push_back(x);
            pm.push_back(-1);
            x = y;
        } else if (op == '*') {
            x = x * y;
        } else if (op == '/') {
            x = x / y;

        }
    }
    pm.push_back(x);

    int ans = pm.front();
    pm.pop_front();


    while (!pm.empty()) {
        int sign = pm.front();
        pm.pop_front();
        int num = pm.front();
        pm.pop_front();
        ans += sign * num;
    }

    return ans;
}
