#include <vector>

int removeElement(std::vector<int>& nums, int val) {

    if (nums.size() < 1) { return 0; }

    auto left = nums.begin();
    auto right = nums.end() - 1;

    while (left <= right) {
        if (*left != val) { ++ left; }
        else {
            *left = *right;
            --right;
        }
    }

    return left - nums.begin();
}
