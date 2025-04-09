#include <algorithm>
#include <utility>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::pair<int, int> helper(TreeNode * node) {
    if (!node) return {0, 0};
    auto left = helper(node->left);
    auto right = helper(node->right);
    int choose = node->val + left.second + right.second;
    int not_choose = std::max(left.first, left.second) + std::max(right.first, right.second);
    return {choose, not_choose};
}

int rob(TreeNode* root) {
    auto val = helper(root);
    return std::max(val.first, val.second);
}
