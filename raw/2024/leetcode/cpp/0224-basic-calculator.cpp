#include <cctype>
#include <stack>
#include <string>

int calculate(std::string s) {


    std::stack<int> levels;
    int acc = 0;
    int num = 0;
    int sign = 1;

    for (char c : s) {


        if (std::isspace(c)) {
            acc += sign * num;
            num = 0;
        } else if (c == '+') {
            acc += sign * num;
            num = 0;
            sign = 1;
        } else if (c == '-') {
            acc += sign * num;
            num = 0;
            sign = -1;
        } else if (c == '(') {
            levels.push(acc);
            levels.push(sign);
            acc = 0;
            sign = 1;
        } else if (c == ')') {
            acc += sign * num;
            acc *= levels.top();
            levels.pop();
            acc += levels.top();
            levels.pop();
            num = 0;
            sign = 1;
        } else {  // number
            num *= 10;
            num += c -'0';
        }
    }

    acc += sign * num;
    return acc;
}
