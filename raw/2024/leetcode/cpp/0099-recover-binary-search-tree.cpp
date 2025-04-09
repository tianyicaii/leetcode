
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


TreeNode * prev = nullptr;
TreeNode * first = nullptr;
TreeNode * second = nullptr;

void in_order(TreeNode* root) {

    if (!root) return;

    in_order(root->left);

    // do sth with root
    if (prev) {

        if (prev->val > root->val) {
            if (!first) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
    }

    prev = root;

    in_order(root->right);

}


void recoverTree(TreeNode* root) {
    in_order(root);
    if (!first) return;

    // swap
    int t = first->val;
    first->val = second->val;
    second->val = t;
}
