#include <queue>
#include <vector>

class NestedInteger {
  public:
    // Constructor initializes an empty nested list.
    NestedInteger();

    // Constructor initializes a single integer.
    NestedInteger(int value);

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    bool isInteger() const;

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    int getInteger() const;

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(const NestedInteger &ni);

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    const std::vector<NestedInteger> &getList() const;
};


int depthSum(std::vector<NestedInteger>& nestedList) {

    std::queue<NestedInteger> q;
    for (auto & ni : nestedList) {
        q.push(ni);
    }

    int ans = 0;
    int depth = 1;
    while (!q.empty()) {
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            auto x = q.front();
            q.pop();
            if (x.isInteger()) {
                ans += depth * x.getInteger();
            } else {
                for (const auto & ni : x.getList()) {
                    q.push(ni);
                }
            }
        }
        depth += 1;
    }
    return ans;
}
