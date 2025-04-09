#include <set>
#include <vector>

bool containsNearbyDuplicate(std::vector<int>& nums, int k) {

    std::set<int> seen;
    for (int i = 0; i < nums.size(); ++i) {
        if (seen.count(nums[i])) return true;
        seen.insert(nums[i]);
        if (seen.size() == k + 1) {
            seen.erase(nums[i - k]);
        }
    }
    return false;
}