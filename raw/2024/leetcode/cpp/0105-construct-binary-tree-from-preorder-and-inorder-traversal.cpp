#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

TreeNode * buildTree(std::vector<int>::iterator pre_b, std::vector<int>::iterator pre_e, std::vector<int>::iterator in_b, std::vector<int>::iterator in_e) {

    if (pre_b == pre_e) return nullptr;

    TreeNode * root = new TreeNode(*pre_b);

    std::vector<int>::iterator m = in_b;
    while (true) {
        if (*m == *pre_b) break;
        ++m;
    }

    int num_left = m - in_b;
    root->left = buildTree(pre_b + 1, pre_b + 1 + num_left, in_b, m);
    root->right = buildTree(pre_b + (num_left + 1), pre_e, m + 1, in_e);
    return root;
}


TreeNode* buildTree(std::vector<int>& preorder, std::vector<int>& inorder) {
    return buildTree(preorder.begin(), preorder.end(), inorder.begin(), inorder.end());
}
