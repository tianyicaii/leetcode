#include <cassert>
#include <stack>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::vector<int> inorderTraversal(TreeNode* root) {

    std::vector<int> ans;
    std::stack<TreeNode *> s;
    std::stack<int> d;

    if (root == nullptr) { return ans; }

    s.push(root);
    d.push(0);

    while (!s.empty()) {

        auto cur = s.top();
        auto dir = d.top();

        if (dir == 0) {

            d.top() = 1;
            if (cur->left) {
                s.push(cur->left);
                d.push(0);
            }

        } else if (dir == 1) {
            d.pop();
            s.pop();
            ans.push_back(cur->val);
            if (cur->right) {
                s.push(cur->right);
                d.push(0);
            }

        } else {
            assert("invalid dir value");
        }
    }

    return ans;
}
