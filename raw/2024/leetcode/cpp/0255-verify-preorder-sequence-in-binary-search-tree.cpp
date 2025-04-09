#include <stack>
#include <vector>

bool verifyPreorder(std::vector<int>& preorder) {

    std::stack<int> roots;

    bool has_lower_limit = false;
    int lower_limit = 0;

    for (int i : preorder) {
        if (has_lower_limit && i <= lower_limit) return false;

        while (!roots.empty() && i > roots.top()) {
            has_lower_limit = true;
            lower_limit = roots.top();
            roots.pop();
        }
        roots.push(i);
    }
    return true;
}
