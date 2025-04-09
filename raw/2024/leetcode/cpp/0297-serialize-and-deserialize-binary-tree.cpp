#include <cassert>
#include <cstddef>
#include <cstdlib>
#include <deque>
#include <sstream>
#include <stack>
#include <string>
#include <utility>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Codec {
public:

    // Encodes a tree to a single string.
    std::string serialize(TreeNode* root) {

        std::string ans;

        std::stack<std::pair<TreeNode *, int>> stack;
        stack.push({root, 0});
    
        while (!stack.empty()) {
            std::pair<TreeNode *, int> & x = stack.top();
            if (x.first == nullptr) {
                ans.append("# ");
                stack.pop();
            } else {
                if (x.second == 0) {
                    ans.append(std::to_string(x.first->val) + " ");
                    x.second = 1;
                    stack.push({x.first->left, 0});
                } else if (x.second == 1) {
                    x.second = 2;
                    stack.push({x.first->right, 0});
                } else {
                    stack.pop();
                }
            }
        }
        ans.pop_back();
        return ans;
    }


    // Decodes your encoded data to tree.
    TreeNode* deserialize(std::string data) {

        std::istringstream input(data);
        std::string e;
        std::stack<std::pair<TreeNode *, int>> stack;
        TreeNode * last;

        while (input >> e) {
            if (e == "#") {
                if (stack.empty()) return nullptr;
                if (stack.top().second == 0) {
                    stack.top().second = 1;
                } else if (stack.top().second == 1) {
                    stack.top().second = 2;
                    while (!stack.empty() && stack.top().second == 2) {
                        last = stack.top().first;
                        stack.pop();
                    }
                }
            } else {
                TreeNode * x = new TreeNode(atoi(e.c_str()));
                if (stack.empty()) stack.push({x, 0});
                else {
                    if (stack.top().second == 0) {
                        stack.top().first->left = x;
                        stack.top().second = 1;
                    } else {
                        assert(stack.top().second == 1);
                        stack.top().first->right = x;
                        stack.top().second = 2;
                    }
                    stack.push({x, 0});
                }
            }
        }
        return last;
    }
};
