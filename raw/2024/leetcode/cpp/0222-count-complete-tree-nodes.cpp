#include <cmath>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


int depth(TreeNode * node) {
    int depth = 0;
    while (node) {
        depth += 1;
        node = node->left;
    }
    return depth;
}

int countNodes(TreeNode* root) {
    if (!root) return 0;

    int left_depth = depth(root->left);
    int right_depth = depth(root->right);

    if (left_depth == right_depth) {
        return countNodes(root->right) + std::pow(2, left_depth);
    }
    return countNodes(root->left) + std::pow(2, right_depth);
}
