#include <cstdlib>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


int closestValue(TreeNode* root, double target) {

    int left = root->val;
    int right = root->val;

    {
        TreeNode * r = root;
        while (r) {
            left = r->val;
            r = r->left;
        }
    }
    {
        TreeNode * r = root;
        while (r) {
            right = r->val;
            r = r->right;
        }
    }
    {
        TreeNode * r = root;
        while (r) {
            if (r->val == target) return target;
            if (r->val < target) {
                left = r->val;
                r = r->right;
            } else {
                right = r->val;
                r = r->left;
            }
        }
    }

    return std::abs(target - left) <= std::abs(target - right) ? left : right;
}
