#include <cstdlib>
#include <map>
#include <vector>
#include <string>


std::map<std::string, std::vector<int>> mem;

std::vector<int> diffWaysToCompute(std::string expression) {

    if (mem.count(expression)) return mem[expression];

    std::vector<int> ans;
    bool has_op = false;

    for (int i = 0; i < expression.size(); ++i) {

        int c = expression[i];

        if (c == '+' || c == '-' || c == '*') {
            has_op = true;

            std::vector<int> left = diffWaysToCompute(expression.substr(0, i));
            std::vector<int> right = diffWaysToCompute(expression.substr(i+1));

            for (int x : left) {
                for (int y : right) {
                    if (c == '+') ans.push_back(x + y);
                    if (c == '-') ans.push_back(x - y);
                    if (c == '*') ans.push_back(x * y);
                }
            }
        }
    }

    if (!has_op) ans.push_back(atoi(expression.c_str()));
    mem[expression] = ans;
    return ans;
}
