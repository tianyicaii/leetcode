#include <algorithm>
#include <deque>
#include <vector>


int get_left(const std::deque<int> & s) {
    if (s.empty()) return -1;
    return s.back();
}

int largestRectangleArea(std::vector<int>& heights) {

    int ans = 0;
    std::deque<int> s;

    for (int i = 0; i <= heights.size(); ++i) {

        int curr_h = (i == heights.size()) ? 0 : heights[i];

        while (!s.empty() && curr_h <= heights[s.back()]) {

            int j = s.back();
            s.pop_back();
            int h = heights[j];
            int l = get_left(s);
            ans = std::max(ans, (i - l - 1) * h);
        }
        s.push_back(i);
    }

    return ans;
}
