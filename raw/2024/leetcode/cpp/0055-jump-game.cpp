#include <vector>

bool canJump(std::vector<int>& nums) {

    if (nums.size() <= 1) { return true; }

    auto left = nums.begin();
    auto right = nums.begin();

    while (right != nums.end()-1) {
        if (left > right) { return false; }

        int dist = std::min(*left, (int)(nums.end() - left - 1));
        right = std::max(right, left + dist);

        ++left;
    }
    return true;
}
