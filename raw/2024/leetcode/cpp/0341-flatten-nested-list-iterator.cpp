#include <stack>
#include <stdexcept>
#include <utility>
#include <vector>

class NestedInteger {
  public:
    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    bool isInteger() const;

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    int getInteger() const;

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    const std::vector<NestedInteger> &getList() const;
};


class NestedIterator {
    std::stack<std::pair<std::vector<NestedInteger>, int>> s;
    int lookahead;
    bool bufferred;

public:
    NestedIterator(std::vector<NestedInteger> & nestedList) : bufferred(false) {
        s.push(std::pair<std::vector<NestedInteger>, int>(nestedList, 0));       
        hasNext(); 
    }
    
    int next() {
        if (!hasNext()) throw std::runtime_error("empty");
        bufferred = false;
        return lookahead;
    }
    
    bool hasNext() {
        if (bufferred) return true;

        while (!s.empty()) {
            auto & t = s.top();
            if (t.second == t.first.size()) {
                s.pop();
                continue;
            }
            auto & t_i = t.first[t.second++];
            if (t_i.isInteger()) {
                lookahead = t_i.getInteger();
                bufferred = true;
                break;
            } else {
                s.push({t_i.getList(), 0});
            }
        }
        return bufferred;
    }
};