

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


int helper(int curr, TreeNode * root) {

    curr *= 10;
    curr += root->val;
    if (!root->left && !root->right) return curr;
    int ans = 0;
    if (root->left) ans += helper(curr, root->left);
    if (root->right) ans += helper(curr, root->right);
    return ans;
}


int sumNumbers(TreeNode* root) {
    return helper(0, root);
}
