#include <algorithm>
#include <vector>

std::vector<std::vector<int>> merge(std::vector<std::vector<int>>& intervals) {

    std::vector<std::vector<int>> ans;

    std::sort(intervals.begin(), intervals.end(),
        [] (const std::vector<int> & a, const std::vector<int> & b) {
            return a.front() < b.front();
        });

    for (const auto & i : intervals) {
        if (ans.empty()) {
            ans.push_back(i);
        } else {
            if (i.front() <= ans.back().back()) {
                ans.back().back() = std::max(ans.back().back(), i.back());
            } else {
                ans.push_back(i);
            }
        }
    }

    return ans;
}
