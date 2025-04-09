#include <stack>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::vector<int> postorderTraversal(TreeNode* root) {

    if (!root) return {};

    std::vector<int> ans;
    std::stack<TreeNode *> s;
    std::stack<int> d;

    s.push(root);
    d.push(0);

    while(!s.empty()) {

        TreeNode * r = s.top();
        int dir = d.top();

        if (dir == 0) {
            d.top() = 1;
            if (r->left) {
                s.push(r->left);
                d.push(0);
            }
        } else if (dir == 1) {
            d.top() = 2;
            if (r->right) {
                s.push(r->right);
                d.push(0);
            }
        } else {  // dir == 2
            s.pop();
            d.pop();
            ans.push_back(r->val);
        }
    }

    return ans;
}
