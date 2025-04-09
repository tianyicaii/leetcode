#include <queue>

class MovingAverage {
    std::queue<int> q;
    int sz;
    int sum;
public:
    MovingAverage(int size) : sz(size), sum(0) {}
    
    double next(int val) {
        q.push(val);
        sum += val;
        if (q.size() > sz) {
            sum -= q.front();
            q.pop();
        }
        return (double)sum / q.size();
    }
};
