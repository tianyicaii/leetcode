#include <stack>

class MyQueue {

    std::stack<int> in;
    std::stack<int> out;

public:
    MyQueue() {}

    void dump() {
        if (out.empty()) {
            while (!in.empty()) {
                int v = in.top();
                in.pop();
                out.push(v);
            }
        }
    }

    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        dump();
        int v = out.top();
        out.pop();
        return v;
    }
    
    int peek() {
        dump();
        return out.top();
    }
    
    bool empty() {
        dump();
        return out.empty();
    }
};
