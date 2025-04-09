#include <algorithm>
#include <cstdlib>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

int is_balanced(TreeNode * root) {
    if (root == nullptr) { return 0; }
    int left = is_balanced(root->left);
    int right = is_balanced(root->right);
    if (left == -1 || right == -1) return -1;
    if (std::abs(left - right) > 1) return -1;
    return std::max(left, right) + 1;
}

bool isBalanced(TreeNode* root) {
    return is_balanced(root) != -1;
}

