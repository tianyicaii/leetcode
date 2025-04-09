#include <vector>

int removeDuplicates(std::vector<int>& nums) {

    if (nums.size() < 3) return nums.size();

    int i = 2;
    int j = 2;

    while (j < nums.size()) {
        if (nums[j] == nums[i-2]) { ++j; }
        else {
            nums[i] = nums[j];
            ++i;
            ++j;
        }
    }

    return i;
}