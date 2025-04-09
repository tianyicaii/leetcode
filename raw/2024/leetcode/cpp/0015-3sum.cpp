#include <algorithm>
#include <vector>

std::vector<std::vector<int>> threeSum(std::vector<int>& nums) {

    std::sort(nums.begin(), nums.end());
    if (nums.size() < 3) { return {}; }
    std::vector<std::vector<int>> ans;

    for (auto i = nums.begin(); i < nums.end() - 2; ) {
        for (auto j = i + 1, k = nums.end() - 1; j < k; ) {
            int sum = *i + *j + *k;
            if (sum > 0) { --k; }
            else if (sum < 0) { ++j; }
            else {
                ans.push_back({*i, *j, *k});
                ++j;
                --k;
                while (j < k && *(j - 1) == *j) { ++j; }
                while (j < k && *(k + 1) == *k) { --k; }
            }
        }
        ++i;
        while (i < nums.end() - 2 && *(i - 1) == *i) { ++i; }
    }
    return ans;

}
