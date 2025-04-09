// https://leetcode.com/problems/two-sum/description/

#include <unordered_map>
#include <vector>

std::vector<int> twoSum(std::vector<int>& nums, int target) {

    std::unordered_map<int, int> val_2_idx;

    for (int i = 0; i < nums.size(); i++) {

        auto it = val_2_idx.find(target - nums[i]);
        if (it != val_2_idx.end()) {
            return {it->second, i};
        }
        val_2_idx.insert({nums[i], i});
    }

    return {};
}
