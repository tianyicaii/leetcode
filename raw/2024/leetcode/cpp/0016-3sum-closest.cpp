#include <algorithm>
#include <cstdlib>
#include <vector>

int threeSumClosest(std::vector<int>& nums, int target) {

    if (nums.size() < 3) { return 0; }

    std::sort(nums.begin(), nums.end());
    int ans = nums[0] + nums[1] + nums[2];
    int min_dist = std::abs(ans - target);

    for (auto i = nums.begin(); i < nums.end() - 2; i++) {
        for (auto j = i + 1, k = nums.end() - 1; j < k; ) {

            int sum = *i + *j + *k;
            int dist = std::abs(sum - target);
            if (dist < min_dist) {
                ans = sum;
                min_dist = dist;
            }

            if (sum < target) { ++j; }
            else if (sum > target) { --k; }
            else return sum;
        }
    }
    return ans;
}