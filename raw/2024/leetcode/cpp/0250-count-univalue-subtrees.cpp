#include <utility>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::pair<bool, int> dfs(TreeNode * r) {
    if (!r->left && !r->right) {
        return {true, 1};
    }

    std::pair<bool, int> left = {false, 0};
    std::pair<bool, int> right = {false, 0};

    if (r->left) {
        left = dfs(r->left);
    }
    if (r->right) {
        right = dfs(r->right);
    }

    if (left.first && right.first) {
        if (r->val == r->left->val && r->val == r->right->val) {
            return {true, left.second + right.second + 1};
        }
    }
    if (left.first) {
        if (!r->right && r->val == r->left->val) return {true, left.second + 1};
    }
    if (right.first) {
        if (!r->left && r->val == r->right->val) return {true, right.second + 1};
    }

    return {false, left.second + right.second};
}

int countUnivalSubtrees(TreeNode* root) {

    if (!root) return 0;
    return dfs(root).second;
}
