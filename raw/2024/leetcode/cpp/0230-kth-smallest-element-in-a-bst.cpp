#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


void inorder(std::vector<int> & lst, TreeNode * root) {
    if (!root) return;
    inorder(lst, root->left);
    lst.push_back(root->val);
    inorder(lst, root->right);
}

int kthSmallest(TreeNode* root, int k) {
    std::vector<int> lst;
    inorder(lst, root);
    return lst[k-1];
}
