#include <vector>

int minPatches(std::vector<int>& nums, int n) {

    int ans = 0;
    long miss = 1;
    int i = 0;
    while (miss <= n) {
        if (i < nums.size() && nums[i] <= miss) {
            miss += nums[i];
            ++i;
        } else {
            miss += miss;
            ans += 1;
        }
    }
    return ans;
}
