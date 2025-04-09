#include <stack>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class BSTIterator {

    std::stack<TreeNode *> nodes;
    std::stack<int> dir;

public:
    BSTIterator(TreeNode* root) {
        if (!root) return;
        nodes.push(root);
        dir.push(0);
    }
    
    int next() {
        while (true) {
            if (dir.top() == 0) {
                dir.top() = 1;
                if (nodes.top()->left) {
                    nodes.push(nodes.top()->left);
                    dir.push(0);
                }
            } else {

                TreeNode * r = nodes.top();
                nodes.pop();
                dir.pop();
                if (r->right) {
                    nodes.push(r->right);
                    dir.push(0);
                }
                return r->val;
            }
        }
    }
    
    bool hasNext() {
        return !nodes.empty();
    }
};
