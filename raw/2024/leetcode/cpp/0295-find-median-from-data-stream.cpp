#include <functional>
#include <queue>

class MedianFinder {

    std::priority_queue<int, std::vector<int>, std::function<bool (const int &, const int &)>> left;
    std::priority_queue<int, std::vector<int>, std::function<bool (const int &, const int &)>> right;

public:
    MedianFinder() :
        left([](const int & a, const int & b) { return a < b; }),
        right([](const int & a, const int & b) { return a >= b; })
    {}
    
    void addNum(int num) {

        if (left.empty() || num > left.top()) right.push(num);
        else left.push(num);

        if (left.size() > right.size()) {
            right.push(left.top());
            left.pop();
        }
        if (left.size() < right.size() - 1) {
            left.push(right.top());
            right.pop();
        }
    }
    
    double findMedian() {
        if (left.size() < right.size()) return right.top();
        else return (left.top() + right.top()) / 2.0;
    }
};
