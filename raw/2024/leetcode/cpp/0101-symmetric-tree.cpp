
#include <deque>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

bool isSymmetric(TreeNode* root) {


    if (!root) return true;

    std::deque<TreeNode *> q;
    q.push_front(root);
    q.push_back(root);

    while (!q.empty()) {
        
        auto x = q.front();
        auto y = q.back();
        q.pop_front();
        q.pop_back();
        if (x->val != y->val) return false;

        if (x->left != nullptr && y->right != nullptr) {
            q.push_front(x->left);
            q.push_back(y->right);
        } else if (x->left == nullptr && y->right == nullptr) {
            ;  // ok
        } else { return false; }

        if (x->right != nullptr && y->left != nullptr) {
            q.push_front(x->right);
            q.push_back(y->left);
        } else if (x->right == nullptr && y->left == nullptr) {
            ;  // ok
        } else { return false; }

    }
    return true;
}
