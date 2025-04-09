#include <cstddef>
#include <map>

class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

Node* copyRandomList(Node* head) {

    if (!head) return nullptr;

    std::map<Node *, Node *> copy;

    Node * curr = head;
    while (curr) {
        Node * cp = new Node(curr->val);
        copy.insert({curr, cp});
        curr = curr->next;
    }

    curr = head;
    while (curr) {
        if (curr->next) copy[curr]->next = copy[curr->next];
        if (curr->random) copy[curr]->random = copy[curr->random];
        curr = curr->next;
    }

    return copy[head];
}
