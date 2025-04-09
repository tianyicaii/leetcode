#include <algorithm>
#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Result {
public:
    int local_max;
    int global_max;

    Result(int l, int g) : local_max(l), global_max(g) {}
    Result() : local_max(0), global_max(0) {}
};


Result helper(TreeNode * root) {

    if (!root->left && !root->right) return Result(root->val, std::max(0, root->val));

    Result left  = (root->left)  ? helper(root->left)  : Result();
    Result right = (root->right) ? helper(root->right) : Result();

    if (!root->left) {
        int local_max = root->val;
        local_max = std::max(right.local_max, local_max);
        local_max = std::max(right.global_max + root->val, local_max);
        int global_max = 0;
        global_max = std::max(right.global_max + root->val, global_max);
        return Result(local_max, global_max);
    }
    if (!root->right) {
        int local_max = root->val;
        local_max = std::max(left.local_max, local_max);
        local_max = std::max(left.global_max + root->val, local_max);
        int global_max = 0;
        global_max = std::max(left.global_max + root->val, global_max);
        return Result(local_max, global_max);
    }

    // both children
    int local_max = root->val;
    local_max = std::max(left.local_max, local_max);
    local_max = std::max(right.local_max, local_max);
    local_max = std::max(left.global_max + right.global_max + root->val, local_max);
    int global_max = 0;
    global_max = std::max(std::max(left.global_max, right.global_max) + root->val, global_max);
    return Result(local_max, global_max);

}

int maxPathSum(TreeNode* root) {
    return helper(root).local_max;
}
