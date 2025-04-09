#include <vector>

void moveZeroes(std::vector<int>& nums) {

    int loc = 0;
    int i = 0;
    while (i < nums.size()) {
        if (nums[i] == 0) ++i;
        else nums[loc++] = nums[i++];
    }
    while (loc < nums.size()) {
        nums[loc++] = 0;
    }
}

