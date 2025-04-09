#include <vector>

std::vector<std::vector<int>> findMissingRanges(std::vector<int>& nums, int lower, int upper) {

    std::vector<std::vector<int>> ans;

    for (int i : nums) {
        if (i == lower) ++lower;  // skip
        else {
            ans.push_back({lower, i-1});
            lower = i+1;
        }
    }
    if (lower <= upper) { ans.push_back({lower, upper}); }
    return ans;
}
