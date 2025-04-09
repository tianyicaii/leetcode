#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

std::vector<TreeNode*> generateTrees(int n) {

    std::vector<std::vector<std::vector<TreeNode *>>> dp(n + 1, std::vector<std::vector<TreeNode *>>(n + 1, std::vector<TreeNode *>()));

    for (int len = 0; len <= n; ++len) {
        for (int start = 0; start + len <= n; ++start) {

            if (len == 0) dp[0][start] = {nullptr};
            else {
                for (int left = 0; left < len; ++left) {
                    for (auto x : dp[left][start]) {
                        for (auto y : dp[len - left - 1][start + left + 1]) {
                            TreeNode * r = new TreeNode(start + left + 1, x, y);
                            dp[len][start].push_back(r);
                        }
                    }
                }
            }
        }
    }

    return dp[n][0];
}
