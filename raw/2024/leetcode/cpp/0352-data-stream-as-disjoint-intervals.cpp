#include <map>
#include <utility>
#include <vector>

class SummaryRanges {

    std::map<int, std::pair<int, int>> intervals;


    bool contains(const std::pair<int, int> & interval, int value) {
        return interval.first <= value && interval.second >= value;
    }


    std::map<int, std::pair<int, int>>::iterator merge_before(std::map<int, std::pair<int, int>>::iterator p) {
        if (p == intervals.begin()) return p;
        auto prev = p;
        prev--;
        int a = prev->second.first;
        int b = prev->second.second;
        int c = p->second.first;
        int d = p->second.second;
        if (b == c - 1) {
            intervals.erase(a);
            intervals.erase(c);
            return intervals.insert({a, {a, d}}).first;
        }
        return p;
    }

    std::map<int, std::pair<int, int>>::iterator merge_after(std::map<int, std::pair<int, int>>::iterator p) {
        auto next = p;
        next++;
        if (next == intervals.end()) return p;
        int a = p->second.first;
        int b = p->second.second;
        int c = next->second.first;
        int d = next->second.second;
        if (b == c - 1) {
            intervals.erase(a);
            intervals.erase(c);
            return intervals.insert({a, {a, d}}).first;
        }
        return p;
    }


public:

    SummaryRanges() {}
    
    void addNum(int value) {

        if (intervals.count(value)) return;

        auto right = intervals.upper_bound(value);
        if (right != intervals.end()) {
            if (contains(right->second, value)) return;
        }

        auto left = right;
        if (right != intervals.begin()) {
            left--;
            if (contains(left->second, value)) return;
        }

        auto p = intervals.insert({value, {value, value}}).first;
        p = merge_before(p);
        p = merge_after(p);
    }
    
    std::vector<std::vector<int>> getIntervals() {
        std::vector<std::vector<int>> ans;
        for (auto & i : intervals) {
            ans.push_back(std::vector<int>{i.second.first, i.second.second});
        }
        return ans;
    }
};
