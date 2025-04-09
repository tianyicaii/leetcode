#include <vector>


void swap(int & x, int & y) {
    int t = x;
    x = y;
    y = t;
}


void reverse(std::vector<int>::iterator b, std::vector<int>::iterator e) {
    while (b < e) {
        swap(*(b++), *(--e));
    }
}


void rotate(std::vector<int>& nums, int k) {

    int N = nums.size();
    k %= N;

    reverse(nums.begin(), nums.end());
    reverse(nums.begin(), nums.begin() + k);
    reverse(nums.begin() + k, nums.end());
}
