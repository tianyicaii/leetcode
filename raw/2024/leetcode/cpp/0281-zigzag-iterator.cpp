#include <queue>
#include <vector>

class ZigzagIterator {

    std::queue<std::vector<int>::iterator> q_b;
    std::queue<std::vector<int>::iterator> q_e;

    void rotate() {

    }

public:

    ZigzagIterator(std::vector<int>& v1, std::vector<int>& v2) {
        if (!v1.empty()) {
            q_b.push(v1.begin());
            q_e.push(v1.end());
        }
        if (!v2.empty()) {
            q_b.push(v2.begin());
            q_e.push(v2.end());
        }
    }

    int next() {
        std::vector<int>::iterator b = q_b.front();
        std::vector<int>::iterator e = q_e.front();
        q_b.pop();
        q_e.pop();
        int v = *b++;
        if (b != e) {
            q_b.push(b);
            q_e.push(e);
        }
        return v;
    }

    bool hasNext() {
        return !q_b.empty();
    }
};
