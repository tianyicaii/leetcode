#include <algorithm>
#include <utility>
#include <vector>

std::vector<int> majorityElement(std::vector<int>& nums) {

    std::vector<std::pair<int, int>> cnts;

    for (int v : nums) {

        if (cnts.empty()) {
            cnts.push_back({v, 1});
            continue;
        }
        if (v == cnts[0].first) {
            cnts[0].second += 1;
            continue;
        }
        if (cnts.size() == 1) {
            cnts.push_back({v, 1});
            continue;
        }
        if (v == cnts[1].first) {
            cnts[1].second += 1;
            continue;
        }

        for (auto it = cnts.begin(); it != cnts.end(); ) {
            it->second -= 1;
            if (!it->second) {
                it = cnts.erase(it);
            } else {
                it += 1;
            }
        }
    }

    std::vector<int> ans;

    for (auto it = cnts.begin(); it != cnts.end(); ++it) {
        int v = it->first;
        int cnt = 0;
        std::for_each(nums.begin(), nums.end(), [&](int i) { if (i == v) cnt += 1; });
        if (cnt > nums.size() / 3) ans.push_back(v);
    }
    return ans;

}
