#include <cstddef>
#include <stack>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

    std::stack<TreeNode *> path;
    std::stack<int> dir;

    path.push(root);
    dir.push(0);

    int found = 0;
    int path_len = -1;

    while (!path.empty()) {

        if (found) {
            path_len = std::min(path_len, (int)path.size());
        }

        int d = dir.top();
        TreeNode * r = path.top();

        if (d == 0 && (r == p || r == q)) {
            found += 1;
            if (found == 1) {
                path_len = path.size();
            } else if (found == 2) {

                while (path.size() > path_len) { path.pop(); }
                return path.top();
            }
        }

        if (d == 0) {
            dir.top() = 1;
            if (r->left) {
                path.push(r->left);
                dir.push(0);
            }
        } else if (d == 1) {
            dir.top() = 2;
            if (r->right) {
                path.push(r->right);
                dir.push(0);
            }
        } else {
            dir.pop();
            path.pop();
        }

    }
    return nullptr;
}