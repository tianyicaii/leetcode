#include <cstdlib>
#include <vector>


void helper(std::vector<std::string>& ans, std::string path, int index, const std::string& input, int target, long prev_result, long prev_operand) {

    if (index == input.size()) {
        if (prev_result == target) {
            ans.push_back(path);
        }
        return;
    }

    for (int i = index; i < input.size(); ++i) {
        if (i != index && input[index] == '0') return;  // no leading zero
        std::string operand = input.substr(index, i - index + 1);
        long o = atol(operand.c_str());
        if (index == 0) {
            helper(ans, path + operand, i + 1, input, target, o, o);
        }
        else {
            helper(ans, path + '+' + operand, i + 1, input, target, prev_result + o, o);
            helper(ans, path + '-' + operand, i + 1, input, target, prev_result - o, -o);
            helper(ans, path + '*' + operand, i + 1, input, target, (prev_result - prev_operand + prev_operand * o), prev_operand * o);
        }
    }
}


std::vector<std::string> addOperators(std::string num, int target) {
    std::vector<std::string> ans;
    std::string path;
    helper(ans, path, 0, num, target, 0, 0);
    return ans;
}
