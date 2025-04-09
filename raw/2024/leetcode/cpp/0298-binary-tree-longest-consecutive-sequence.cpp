
#include <algorithm>
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

int max = 0;
int helper(TreeNode* root) {
    if (root == nullptr) return 0;

    int left = 1;
    int right = 1;
    if (root->left) {
        left = helper(root->left);
        if (root->val == root->left->val - 1) {
            left += 1;
        } else {
            left = 1;
        }
    }
    if (root->right) {
        right = helper(root->right);
        if (root->val == root->right->val - 1) {
            right += 1;
        } else {
            right = 1;
        }
    }
    max = std::max(max, std::max(left, right));
    return std::max(left, right);
}


int longestConsecutive(TreeNode* root) {
    max = 0;
    helper(root);
    return max;
}