#include <queue>

class MyStack {

    std::queue<int> q;

public:
    MyStack() {}
    
    void push(int x) {
        int sz = q.size();
        q.push(x);
        for (int i = 0; i < sz; ++i) {
            int v = q.front();
            q.pop();
            q.push(v);
        }
    }
    
    int pop() {
        int v = q.front();
        q.pop();
        return v;
    }
    
    int top() {
        return q.front();
    }
    
    bool empty() {
        return q.empty();
    }
};