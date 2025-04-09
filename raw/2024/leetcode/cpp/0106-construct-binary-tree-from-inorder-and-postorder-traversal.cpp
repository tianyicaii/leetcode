#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};



TreeNode * buildTree(std::vector<int>::iterator post_b, std::vector<int>::iterator post_e, std::vector<int>::iterator in_b, std::vector<int>::iterator in_e) {

    if (post_b == post_e) return nullptr;

    TreeNode * root = new TreeNode(*(post_e - 1));

    std::vector<int>::iterator m = in_b;
    while (true) {
        if (*m == root->val) break;
        ++m;
    }

    int num_left = m - in_b;
    int num_right = in_e - m - 1;

    root->left = buildTree(post_b, post_b + num_left, in_b, m);
    root->right = buildTree(post_b + num_left, post_e-1, m + 1, m + 1 + num_right);
    return root;
}

TreeNode* buildTree(std::vector<int>& inorder, std::vector<int>& postorder) {
    return buildTree(postorder.begin(), postorder.end(), inorder.begin(), inorder.end());
}
