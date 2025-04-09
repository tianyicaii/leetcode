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


std::vector<int> preorderTraversal(TreeNode* root) {

    if (!root) return {};

    std::vector<int> ans;
    std::stack<TreeNode *> s;
    s.push(root);

    while (!s.empty()) {
        auto c = s.top();
        s.pop();
        ans.push_back(c->val);
        if (c->right) s.push(c->right);
        if (c->left) s.push(c->left);
    }
    return ans;
}