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


std::vector<std::vector<int>> zigzagLevelOrder(TreeNode* root) {

    std::vector<std::vector<int>> ans;
    std::queue<TreeNode *> q;

    if (!root) return ans;
    q.push(root);

    int v = 0;
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
        if (v % 2) {
            ans.push_back(std::vector<int>(lev.rbegin(), lev.rend()));
        } else {
            ans.push_back(std::move(lev));
        }
        
        ++v;
    }

    return ans;
}
