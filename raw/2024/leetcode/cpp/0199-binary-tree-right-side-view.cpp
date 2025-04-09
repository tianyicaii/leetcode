#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::vector<int> ans;

void dfs(int i, TreeNode * c) {
    if (!c) return;
    if (ans.size() == i) { ans.push_back(c->val); }
    else { ans[i] = c->val; }
    dfs(i+1, c->left);
    dfs(i+1, c->right);
}

std::vector<int> rightSideView(TreeNode* root) {

    ans.clear();
    dfs(0, root);
    return ans;
}
