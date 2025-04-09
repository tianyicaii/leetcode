#include <stack>

class MinStack {
public:

    std::stack<int> s_value;
    std::stack<int> s_min;

    MinStack() {}
    
    void push(int val) {
        s_value.push(val);
        if (s_min.empty()) {
            s_min.push(val);
        } else {
            if (s_min.top() <= val) {
                s_min.push(s_min.top());
            } else {
                s_min.push(val);
            }
        }
    }

    void pop() {
        s_value.pop();
        s_min.pop();        
    }

    int top() {
        return s_value.top();        
    }
    
    int getMin() {
        return s_min.top();
    }
};
