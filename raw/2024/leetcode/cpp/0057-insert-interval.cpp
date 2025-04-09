#include <algorithm>
#include <vector>

std::vector<std::vector<int>> insert(std::vector<std::vector<int>>& intervals, std::vector<int>& newInterval) {

    std::vector<std::vector<int>> ans;
    auto merged = newInterval;
    for (const auto & i : intervals) {
        if (i[1] < newInterval[0]) { ans.push_back(i); }
        else if (i[0] > newInterval[1]) { ans.push_back(i);; }
        else {
            newInterval[0] = std::min(newInterval[0], i[0]);
            newInterval[1] = std::max(newInterval[1], i[1]);
        }
    }

    auto i = ans.begin();
    while (i < ans.end()) {
        if (i->front() < newInterval[0]) { ++i; }
        else { break; }
    }
    ans.insert(i, newInterval);
    return ans;
}