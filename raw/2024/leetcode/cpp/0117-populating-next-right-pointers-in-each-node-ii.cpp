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

    Node * next_lev = root;

    while (next_lev) {
        Node * curr = next_lev;

        next_lev = nullptr;
        Node * next_end = nullptr;

        while (curr) {


            if (curr->left && curr->right) curr->left->next = curr->right;


            if (!next_lev) {
                if (curr->left) {
                    next_lev = curr->left;
                } else if (curr->right) {
                    next_lev = curr->right;
                }
            }

            if (!next_end) {
                if (curr->left) {
                    next_end = curr->left;
                }
                if (curr->right) {
                    next_end = curr->right;
                }
            } else {
                if (curr->left) {
                    next_end->next = curr->left;
                    next_end = curr->left;
                }
                if (curr->right) {
                    next_end->next = curr->right;
                    next_end = curr->right;
                }
            }

            curr = curr->next;
        }
    }

    return root;
}
