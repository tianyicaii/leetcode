#include <map>

class TwoSum {

private:

    std::map<long, int> cnt;

public:
    TwoSum() {}
    
    void add(int number) {
        cnt[number] += 1;
    }
    
    bool find(int value) {
        long V = value;
        for (const auto & i : cnt) {
            long v = i.first;
            int c = i.second;
            if (v + v == V) { return c >= 2; }
            if (cnt.count(V - v)) { return true; }
        }
        return false;
    }
};
