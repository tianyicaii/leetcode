#include <string>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


std::string get_path(const std::vector<int> path) {
    std::string ans;
    for (int i = 0; i < path.size(); ++i) {
        if (i == 0) ans += std::to_string(path[i]);
        else ans += "->" + std::to_string(path[i]);
    }
    return ans;
}


void traverse(std::vector<std::string> & ans, std::vector<int> & path, TreeNode * r) {
    path.push_back(r->val);
    if (!r->left && !r->right) {
        ans.push_back(get_path(path));
    }
    if (r->left) traverse(ans, path, r->left);
    if (r->right) traverse(ans, path, r->right);
    path.pop_back();
}


std::vector<std::string> binaryTreePaths(TreeNode* root) {
    if (!root) return {};
    std::vector<int> path;
    std::vector<std::string> ans;
    traverse(ans, path, root);
    return ans;
}
