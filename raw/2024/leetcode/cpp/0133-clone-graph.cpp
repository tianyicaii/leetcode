#include <map>
#include <set>
#include <vector>

class Node {
public:
    int val;
    std::vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = std::vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = std::vector<Node*>();
    }
    Node(int _val, std::vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};


std::map<Node *, Node *> clone;
std::set<Node *> seen;

void dfs(Node * node) {
    seen.insert(node);
    Node * n_ = new Node(node->val);
    clone.insert({node, n_});
    for (auto x : node->neighbors) {
        if (seen.find(x) != seen.end()) continue;
        dfs(x);
    }
}


Node* cloneGraph(Node* node) {

    if (!node) return nullptr;

    clone.clear();
    seen.clear();
    dfs(node);

    for (auto & c : clone) {
        auto ori = c.first;
        auto clo = c.second;
        for (auto x : ori->neighbors) {
            auto xx = clone[x];
            clo->neighbors.push_back(xx);
        }
    }

    return clone[node];
}
