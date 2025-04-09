#include <cstddef>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {

    TreeNode * succ = nullptr;
    TreeNode * curr = root;

    while (curr) {
        if (curr->val <= p->val) curr = curr->right;
        else {
            succ = curr;
            curr = curr->left;
        } 
    }

    return succ;
}
