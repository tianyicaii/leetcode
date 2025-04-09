#include <vector>

template<typename T> void swap(T& a, T& b) {
    T t = a;
    a = b;
    b = t;
}

void nextPermutation(std::vector<int>& nums) {

    if (nums.size() < 2) { return; }

    for (auto left = nums.rbegin() + 1; left != nums.rend(); ++left) {
        for (auto right = nums.rbegin(); right != left; ++right) {
            if (*right > *left) {
                swap(*left, *right);
                for (auto a = left - 1, b = nums.rbegin(); a > b; --a, ++b) {
                    swap(*a, *b);
                }
                return;
            }
        }
    }

    for (auto a = nums.begin(), b = nums.end() - 1; a < b; ++a, --b) {
        swap(*a, *b);
    }
}
