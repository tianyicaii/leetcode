#include <vector>


int findDuplicate(std::vector<int>& nums) {

    int i = nums[0];
    int j = nums[nums[0]];
    while (i != j) {
        i = nums[i];
        j = nums[nums[j]];
    }


    i = nums[0];
    j = nums[j];
    while (i != j) {
        i = nums[i];
        j = nums[j];
    }
    return i;
}
