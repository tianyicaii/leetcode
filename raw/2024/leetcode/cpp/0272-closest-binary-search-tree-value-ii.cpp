#include <cassert>
#include <cstdlib>
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


class Pred {

    std::stack<TreeNode *> nodes;
    std::stack<int> dir;
    double target;

public:

    Pred(TreeNode * r, double target_) : target(target_) {
        if (r) {
            nodes.push(r);
            dir.push(0);
        }
    }

    bool has_pred() {
        while (!nodes.empty()) {
            int d = dir.top();
            TreeNode * x = nodes.top();
            if (d == 0) {
                dir.top() = 1;
                if (x->val <= target && x->right) {
                    nodes.push(x->right);
                    dir.push(0);
                }
            } else {  // dir == 1
                if (x->val > target) {
                    nodes.pop();
                    dir.pop();
                    if (x->left) {
                        nodes.push(x->left);
                        dir.push(0);
                    }
                } else {
                    break;
                }
            }
        }
        return !nodes.empty();
    }

    int pred() {
        return nodes.top()->val;
    }

    void pop() {
        int d = dir.top();
        TreeNode * x = nodes.top();
        assert(d == 1);
        nodes.pop();
        dir.pop();
        if (x->left) {
            nodes.push(x->left);
            dir.push(0);
        }
    }
};


class Succ {

    std::stack<TreeNode *> nodes;
    std::stack<int> dir;
    double target;

public:

    Succ(TreeNode * r, double target_) : target(target_) {
        if (r) {
            nodes.push(r);
            dir.push(0);
        }
    }

    bool has_succ() {
        while (!nodes.empty()) {
            int d = dir.top();
            TreeNode * x = nodes.top();
            if (d == 0) {
                dir.top() = 1;
                if (x->val > target && x->left) {
                    nodes.push(x->left);
                    dir.push(0);
                }
            } else {  // dir == 1
                if (x->val <= target) {
                    nodes.pop();
                    dir.pop();
                    if (x->right) {
                        nodes.push(x->right);
                        dir.push(0);
                    }
                } else {
                    break;
                }
            }
        }
        return !nodes.empty();
    }

    int succ() {
        return nodes.top()->val;
    }

    void pop() {
        int d = dir.top();
        TreeNode * x = nodes.top();
        assert(d == 1);
        nodes.pop();
        dir.pop();
        if (x->right) {
            nodes.push(x->right);
            dir.push(0);
        }
    }
};


std::vector<int> closestKValues(TreeNode* root, double target, int k) {
    std::vector<int> ans;

    Pred p(root, target);
    Succ s(root, target);

    while (ans.size() < k && p.has_pred() && s.has_succ()) {
        int x = p.pred();
        int y = s.succ();

        if (std::abs(x - target) <= std::abs(y - target)) {
            ans.push_back(x);
            p.pop();
        } else {
            ans.push_back(y);
            s.pop();
        }
    }

    while (ans.size() < k && p.has_pred()) {
        int x = p.pred();
        ans.push_back(x);
        p.pop();
    }

    while (ans.size() < k && s.has_succ()) {
        int y = s.succ();
        ans.push_back(y);
        s.pop();
    }

    return ans;
}
