#include <vector>

int minSubArrayLen(int target, std::vector<int>& nums) {

    int i = 0;
    int j = 0;
    int sum = 0;
    int len = nums.size() + 1;

    while (i < nums.size()) {
        while (j < nums.size() && sum < target) {
            sum += nums[j];
            ++j;
        }
        if (sum < target) break;
        while (sum >= target) {
            len = std::min(len, j - i);
            sum -= nums[i];
            ++i;
        }
    }
    return len > nums.size() ? 0 : len;
}
