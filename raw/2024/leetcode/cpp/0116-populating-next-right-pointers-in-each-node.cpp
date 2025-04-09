#include <cstddef>

// Definition for a Node.

class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};

Node* connect(Node* root) {

    if (!root) return nullptr;

    Node * next_level = root;

    while (next_level) {

        Node * curr = next_level;
        next_level = curr->left;

        while (curr) {
            if (curr->left) curr->left->next = curr->right;
            if (curr->next) {
                if (curr->right) curr->right->next = curr->next->left;
            }
            curr = curr->next;
        }
    }

    return root;
}