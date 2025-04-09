#include <queue>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::vector<std::vector<int>> levelOrder(TreeNode* root) {

    std::vector<std::vector<int>> ans;
    std::queue<TreeNode *> q;

    if (!root) return ans;

    q.push(root);

    while (!q.empty()) {
        int sz = q.size();
        std::vector<int> lev;
        for (int i = 0; i < sz; ++i) {
            TreeNode * x = q.front();
            q.pop();
            lev.push_back(x->val);
            if (x->left) q.push(x->left);
            if (x->right) q.push(x->right);
        }
        ans.push_back(std::move(lev));
    }

    return ans;
}
