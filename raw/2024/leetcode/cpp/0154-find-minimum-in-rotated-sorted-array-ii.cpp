#include <algorithm>
#include <vector>

int findMin(std::vector<int>& nums) {

    int ans = nums[0];
    for (int i : nums) {
        ans = std::min(ans, i);
    }
    return ans;
}
