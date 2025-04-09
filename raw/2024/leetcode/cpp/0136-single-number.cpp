#include <vector>

int singleNumber(std::vector<int>& nums) {
    int ans = 0;
    for (int i : nums) {
        ans ^= i;
    }
    return ans;
}
