#include <vector>

int findMin(std::vector<int>& nums) {

    auto b = nums.begin();
    auto e = nums.end();

    if (*(e-1) >= *b) return *b;  // no rotation

    while (b < e - 1) {
        auto m = b + (e - b) / 2;

        if (*m > *b) {
            b = m;
        } else {
            e = m;
        }
    }

    return *e;
}
