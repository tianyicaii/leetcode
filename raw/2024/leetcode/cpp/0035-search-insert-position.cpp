#include <vector>

int searchInsert(std::vector<int>& nums, int target) {

    auto b = nums.begin();
    auto e = nums.end();

    while (b < e) {
        auto m = b + (e - b) / 2;
        if (*m < target) {
            b = m+1;
        } else {
            e = m;
        }
    }
    return b - nums.begin();
}
