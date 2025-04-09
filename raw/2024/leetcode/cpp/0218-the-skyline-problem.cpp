#include <algorithm>
#include <functional>
#include <queue>
#include <utility>
#include <vector>


std::vector<std::vector<int>> getSkyline(std::vector<std::vector<int>>& buildings) {

    std::vector<std::vector<int>> ans;

    std::vector<std::pair<int, int>> p_2_b;
    for (int b = 0; b < buildings.size(); ++b) {
        p_2_b.push_back({buildings[b][0], b});
        p_2_b.push_back({buildings[b][1], b});
    }
    std::sort(p_2_b.begin(), p_2_b.end());

    std::priority_queue<int, std::vector<int>, std::function<bool(int, int)>> under_scan(
        [&](int b1, int b2) {return buildings[b1][2] < buildings[b2][2];});

    int curr_height = 0;
    int p = 0;

    while (p < p_2_b.size()) {

        int x = p_2_b[p].first;
        while (p < p_2_b.size() && p_2_b[p].first == x) {
            int b = p_2_b[p].second;
            if (buildings[b][0] == x) {
                // building starts
                under_scan.push(b);
            }
            ++p;
        }

        while (!under_scan.empty() && buildings[under_scan.top()][1] <= x) {
            under_scan.pop();
        }

        int height = under_scan.empty() ? 0 : buildings[under_scan.top()][2];
        if (curr_height != height) {
            ans.push_back({x, height});
            curr_height = height;
        }
    }

    return ans;
}
