


#include <algorithm>
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


struct Result {
    bool is_valid_bst_;
    int min_;
    int max_;
    int cnt_;
    Result(bool is_valid_bst, int min, int max, int cnt) :
        is_valid_bst_(is_valid_bst), min_(min), max_(max), cnt_(cnt) {}
};


Result helper(TreeNode * node) {

    if (!node->left && !node->right) {
        return Result(true, node->val, node->val, 1);
    }
    if (node->left && !node->right) {
        Result L = helper(node->left);
        if (L.is_valid_bst_ && L.max_ < node->val) {
            return Result(true, L.min_, node->val, L.cnt_ + 1);
        } else {
            return Result(false, 0, 0, L.cnt_);
        }
    }
    if (!node->left && node->right) {
        Result R = helper(node->right);
        if (R.is_valid_bst_ && R.min_ > node->val) {
            return Result(true, node->val, R.max_, R.cnt_ + 1);
        } else {
            return Result(false, 0, 0, R.cnt_);
        }
    }
    // node->left && node->right
    Result L = helper(node->left);
    Result R = helper(node->right);
    if (L.is_valid_bst_ && L.max_ < node->val && R.is_valid_bst_ && R.min_ > node->val) {
        return Result(true, L.min_, R.max_, L.cnt_ + R.cnt_ + 1);
    } else {
        return Result(false, 0, 0, std::max(L.cnt_, R.cnt_));
    }
}


int largestBSTSubtree(TreeNode* root) {

    if (!root) return 0;
    return helper(root).cnt_;
}
