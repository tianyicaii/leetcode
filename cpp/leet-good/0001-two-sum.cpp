// https://leetcode.com/problems/two-sum/description/
// Asked once in 2014 for google internship; asked once more in 2018 for google full time.


#include <algorithm>
#include <map>
#include <vector>


std::vector<int> twoSum(std::vector<int>& nums, int target) {

    std::map<int, std::vector<int>> val_2_idx;

    // build map
    {
        int idx = 0;
        std::for_each(nums.begin(), nums.end(), [&idx, &val_2_idx](int x) {
            val_2_idx[x].push_back(idx++);
        });
    }

    // search map
    {
        for (const auto & i : val_2_idx) {
            int x = i.first;
            int y = target - x;
            if (x == y) {
                if (val_2_idx[x].size() >= 2) {
                    return {val_2_idx[x][0], val_2_idx[x][1]};
                }
            } else {
                if (val_2_idx.count(y)) {
                    return {val_2_idx[x][0], val_2_idx[y][0]};
                }
            }
        }
    }

    // non-reachable
    return {};
}
