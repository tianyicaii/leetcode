#include <cassert>
#include <memory>
#include <queue>
#include <vector>


struct Node {
    int l;
    int r;
    int v;
    std::unique_ptr<Node> L;
    std::unique_ptr<Node> R;
    Node(int l_, int r_, int v_, Node * L_, Node * R_) :
        l(l_), r(r_), v(v_), L(L_), R(R_) {}

};


class NumArray {

    std::unique_ptr<Node> root;

public:
    NumArray(std::vector<int>& nums) {

        std::queue<Node *> nodes;
        for (int i = 0; i < nums.size(); ++i) {
            nodes.push(new Node(i, i, nums[i], nullptr, nullptr));
        }
        while (nodes.size() > 1) {
            int sz = nodes.size();
            int i = 0;
            while (i < sz - 1) {
                Node * left = nodes.front();
                nodes.pop();
                Node * right = nodes.front();
                nodes.pop();
                i += 2;
                nodes.push(new Node(left->l, right->r, left->v + right->v, left, right));
            }
            if (i < sz) {
                Node * leftover = nodes.front();
                nodes.pop();
                nodes.push(leftover);
            }
        }
        root.reset(nodes.front());
    }

    int helper_update( Node * c, int index, int val) {
        if (c->l == c->r) {
            int diff = val - c->v;
            c->v = val;
            return diff;
        }
        int diff = 0;
        if (c->L->r >= index) {
            diff = helper_update(c->L.get(), index, val);
        } else {
            assert(c->R->l <= index);
            diff = helper_update(c->R.get(), index, val);
        }
        c->v += diff;
        return diff;
    }

    void update(int index, int val) {
        Node * c = root.get();
        helper_update(c, index, val);
    }

    int find(Node * c, int len) {
        if (c->r < len) {
            return c->v;
        }
        if (c->l >= len) {
            return 0;
        }
        return find(c->L.get(), len) + find(c->R.get(), len);
    }

    int sumRange(int left, int right) {
        Node * c = root.get();
        int L = find(c, left);
        int R = find(c, right + 1);
        return R - L;
    }
};
