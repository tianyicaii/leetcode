
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


bool isValidBST(TreeNode * curr, TreeNode * left, TreeNode * right) {

    if (curr == nullptr) return true;
    if (left && left->val >= curr->val) return false;
    if (right && right->val <= curr->val) return false;
    return isValidBST(curr->left, left, curr) && isValidBST(curr->right, curr, right);

}

bool isValidBST(TreeNode* root) {

    return isValidBST(root, nullptr, nullptr);
}
