#include <vector>


void swap(int & a, int & b) {
    int t = a;
    a = b;
    b = t;
}


void wiggleSort(std::vector<int>& nums) {

    for (int i = 1; i < nums.size(); ++i) {

        if (i % 2) {
            if (nums[i] < nums[i-1]) {
                swap(nums[i], nums[i-1]);
            }
        } else {
            if (nums[i] > nums[i-1]) {
                swap(nums[i], nums[i-1]);
            }
        }
    }
}
