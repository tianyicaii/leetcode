#include <algorithm>
#include <map>
#include <queue>
#include <utility>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

std::vector<std::vector<int>> verticalOrder(TreeNode* root) {

    std::map<int, std::vector<int>> cols;
    std::queue<std::pair<int, TreeNode *>> q;
    if (root) {
        q.push({0, root});
    }

    while (!q.empty()) {
        auto x = q.front();
        q.pop();
        int idx = x.first;
        TreeNode * node = x.second;
        cols[idx].push_back(node->val);
        if (node->left) { q.push({idx - 1, node->left}); }
        if (node->right) { q.push({idx + 1, node->right}); }
    }

    std::vector<std::vector<int>> ans;
    std::for_each(cols.begin(), cols.end(),
        [&ans](std::pair<int, std::vector<int>> i) {
            ans.push_back(i.second);
    });
    return ans;
}
