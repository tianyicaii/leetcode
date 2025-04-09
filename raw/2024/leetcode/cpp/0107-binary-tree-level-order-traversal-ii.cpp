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

std::vector<std::vector<int>> levelOrderBottom(TreeNode* root) {

    std::vector<std::vector<int>> ans;
    if (!root) return ans;
    std::queue<TreeNode *> q;
    q.push(root);

    while (!q.empty()) {

        int sz = q.size();
        std::vector<int> lev;
        for (int i = 0; i < sz; ++i) {
            TreeNode * curr = q.front();
            q.pop();
            lev.push_back(curr->val);
            if (curr->left) q.push(curr->left);
            if (curr->right) q.push((curr->right));
        }
        ans.push_back(lev);
    }

    return std::vector<std::vector<int>>(ans.rbegin(), ans.rend());
}

