#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::vector<std::vector<int>> ans;


void find(std::vector<int> & path, TreeNode * curr, int target) {

    path.push_back(curr->val);

    if (!curr->left && !curr->right) {
        if (target == curr->val) {
            ans.push_back(path);
        }
    }

    if (curr->left) find(path, curr->left, target - curr->val);
    if (curr->right) find(path, curr->right, target - curr->val);
    path.pop_back();
}

std::vector<std::vector<int>> pathSum(TreeNode* root, int targetSum) {

    ans.clear();
    if (!root) return ans;
    std::vector<int> path;
    find(path, root, targetSum);
    return ans;
}
