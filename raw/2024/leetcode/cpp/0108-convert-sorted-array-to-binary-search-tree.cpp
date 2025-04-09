#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


TreeNode * build(std::vector<int>::iterator b, std::vector<int>::iterator e) {
    if (b == e) return nullptr;

    auto m = b + (e - b) / 2;
    TreeNode * root = new TreeNode(*m);

    root->left = build(b, m);
    root->right = build(m + 1, e);
    return root;
}

TreeNode* sortedArrayToBST(std::vector<int>& nums) {
    return build(nums.begin(), nums.end());
}
