#include <vector>


void swap(int & a, int & b) {
    int t = a;
    a = b;
    b = t;
}

int firstMissingPositive(std::vector<int>& nums) {

    int i = 0;
    while (i < nums.size()) {
        if (nums[i] < 1 || nums[i] > nums.size()) { ++i; }
        else if (nums[i] == i + 1) { ++i; }
        else if (nums[nums[i] - 1] == nums[i]) { ++i; }  // ignore duplicates
        else {
            swap(nums[i], nums[nums[i] - 1]);
        }
    }

    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] != i + 1) { return i + 1; }
    }

    return nums.size() + 1;
}
