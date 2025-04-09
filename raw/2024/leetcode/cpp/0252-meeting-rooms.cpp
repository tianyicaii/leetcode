#include <algorithm>
#include <vector>

bool canAttendMeetings(std::vector<std::vector<int>>& intervals) {

    if (intervals.empty()) return true;

    std::sort(intervals.begin(), intervals.end(), [](std::vector<int> & a, std::vector<int> & b) { return a[0] < b[0]; });

    int last_end = intervals[0][0];

    for (const auto & i : intervals) {
        if (i[0] < last_end) return false;
        last_end = i[1];
    }
    return true;
}
