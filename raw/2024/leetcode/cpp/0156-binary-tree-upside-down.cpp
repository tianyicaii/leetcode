

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

TreeNode* upsideDownBinaryTree(TreeNode* root) {

    if (!root) return nullptr;
    if (!root->left) return root;

    TreeNode * new_root = upsideDownBinaryTree(root->left);
    root->left->right = root;
    root->left->left = root->right;
    root->right = nullptr;
    root->left = nullptr;
    return new_root;
}
