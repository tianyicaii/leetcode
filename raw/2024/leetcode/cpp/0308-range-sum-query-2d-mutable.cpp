#include <cassert>
#include <map>
#include <memory>
#include <utility>
#include <vector>


struct Node {

    std::vector<std::unique_ptr<Node>> children;
    int top;
    int bottom;
    int left;
    int right;
    int sum = 0;

    Node(Node * a, Node * b, Node * c, Node * d) {
        children.push_back(std::unique_ptr<Node>(a));
        children.push_back(std::unique_ptr<Node>(b));
        children.push_back(std::unique_ptr<Node>(c));
        children.push_back(std::unique_ptr<Node>(d));

        top = a->top;
        left = a->left;
        right = a->right;
        bottom = a->bottom;
        sum = a->sum;

        if (b) {
            right = b->right;
            sum += b->sum;
        }
        if (c) {
            bottom = c->bottom;
            sum += c->sum;
        }
        if (d) {
            sum += d->sum;
        }
    }

    Node(int t, int b, int l, int r, int v) :
        top(t), bottom(b), left(l), right(r), sum(v) {}
};


class NumMatrix {

    std::unique_ptr<Node> root;

public:

    NumMatrix(std::vector<std::vector<int>>& matrix) {

        int M = matrix.size();
        int N = matrix[0].size();
        std::map<std::pair<std::pair<int, int>, std::pair<int, int>>, Node *> nodes;

        for (int size = 1; size/2 < M || size/2 < N; size *= 2) {

            std::map<std::pair<std::pair<int, int>, std::pair<int, int>>, Node *> nodes2;

            for (int i = 0; i < M; i += size) {
                for (int j = 0; j < N; j += size) {
                    if (size == 1) {
                        nodes2.insert({{{i, j}, {i, j}}, new Node(i, i, j, j, matrix[i][j])});
                    }
                    else {
                        std::pair<std::pair<int, int>, std::pair<int, int>> key_a = {{i, j}, {i + size/2-1, j + size/2-1}};
                        std::pair<std::pair<int, int>, std::pair<int, int>> key_b = {{i, j + size/2}, {i + size/2-1, j + size-1}};
                        std::pair<std::pair<int, int>, std::pair<int, int>> key_c = {{i + size/2, j}, {i + size-1, j + size/2-1}};
                        std::pair<std::pair<int, int>, std::pair<int, int>> key_d = {{i + size/2, j + size/2}, {i + size-1, j + size-1}};

                        Node * a = (nodes.count(key_a)) ? nodes[key_a] : nullptr;
                        Node * b = (nodes.count(key_b)) ? nodes[key_b] : nullptr;
                        Node * c = (nodes.count(key_c)) ? nodes[key_c] : nullptr;
                        Node * d = (nodes.count(key_d)) ? nodes[key_d] : nullptr;

                        assert(a);

                        nodes2.insert({ {{i, j}, {i + size-1, j + size-1}}, new Node(a, b, c, d)});
                    }
                }
            }
            nodes = nodes2;
        }
        assert(nodes.size() == 1);
        root.reset(nodes.begin()->second);
    }

    int update(Node * x, int row, int col, int v) {
        if (x->top == x->bottom && x->left == x->right) {
            assert(x->top == row);
            assert(x->left == col);
            int diff = v - x->sum;
            x->sum = v;
            return diff;
        }

        int diff = 0;
        bool updated = false;

        for (int i = 0; i < 4; ++i) {
            Node * y = x->children[i].get();
            if (!y) continue;
            if (y->top <= row && y->bottom >= row && y->left <= col && y->right >= col) {
                assert(!updated);
                updated = true;
                diff = update(y, row, col, v); 
            }
        }
        assert(updated);
        x->sum += diff;
        return diff;
    }

    void update(int row, int col, int val) {
        update(root.get(), row, col, val);
    }
    
    int sumRegion(Node * x, int row1, int col1, int row2, int col2) {
        if (x->top >= row1 && x->bottom <= row2 && x->left >= col1 && x->right <= col2) { return x->sum; }
        if (x->top > row2 || x->bottom < row1 || x->left > col2 || x->right < col1) { return 0; }
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            Node * y = x->children[i].get();
            if (!y) continue;
            ans += sumRegion(y, row1, col1, row2, col2); 
        }
        return ans;
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root.get(), row1, col1, row2, col2);
    }
};
