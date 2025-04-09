#include <vector>

int findPeakElement(std::vector<int>& nums) {

    if (nums.size() == 1) return 0;
    if (nums[0] > nums[1]) return 0;

    int i = 0;
    int j = nums.size() - 1;

    if (nums[j] > nums[j-1]) return j;

    while (true) {
        auto m = i + (j - i) / 2;
        if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m;
        if (nums[m] > nums[m-1]) i = m;
        else j = m;
    }
}
