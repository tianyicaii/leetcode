
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


TreeNode * helper(TreeNode * root) {

    if (!root->left && !root->right) return root;

    TreeNode * e = root;
    TreeNode * left = root->left;
    TreeNode * right = root->right;


    if (left) {
        e->right = left;
        e = helper(left);
    }
    if (right) {
        e->right =right;
        e = helper(right);
    }

    root->left = nullptr;  // remember
    return e;
}


void flatten(TreeNode* root) {

    if (!root) return;
    helper(root);
}
