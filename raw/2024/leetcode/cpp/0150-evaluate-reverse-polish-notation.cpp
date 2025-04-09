#include <cstdlib>
#include <stack>
#include <vector>

int evalRPN(std::vector<std::string>& tokens) {

    std::stack<int> s;

    for (const auto & t : tokens) {
        if (t == "+") {
            int a = s.top();
            s.pop();
            int b = s.top();
            s.pop();
            s.push(b + a);
        } else if (t == "-") {
            int a = s.top();
            s.pop();
            int b = s.top();
            s.pop();
            s.push(b - a);
        } else if (t == "*") {
            int a = s.top();
            s.pop();
            int b = s.top();
            s.pop();
            s.push(b * a);
        } else if (t == "/") {
            int a = s.top();
            s.pop();
            int b = s.top();
            s.pop();
            s.push(b / a);
        } else {
            s.push(atoi(t.c_str()));
        }
    }

    return s.top();
}
