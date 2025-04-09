
#include <string>
#include <vector>


std::vector<std::string> ans;
std::string path;

void gen(int left, int right) {

    if (left == 0 && right == 0) {
        ans.push_back(path);
        return;
    }
    if (left != 0) {
        path.push_back('(');
        gen(left - 1, right);
        path.pop_back();
    }
    if (left < right) {
        path.push_back(')');
        gen(left, right - 1);
        path.pop_back();
    }
}

std::vector<std::string> generateParenthesis(int n) {
    ans.clear();
    path.clear();
    gen(n, n);
    return ans;
}


