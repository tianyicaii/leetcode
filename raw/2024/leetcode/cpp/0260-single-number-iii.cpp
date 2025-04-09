#include <vector>

std::vector<int> singleNumber(std::vector<int>& nums) {

    int x = 0;
    for (int i : nums) {
        x ^= i;
    }

    int last_one_bit = 0;
    if (x & (1 << 31)) last_one_bit = (1 << 31);  // avoid overflow
    else last_one_bit = x - (x & (x-1));

    int a = 0;
    int b = 0;
    for (int i : nums) {
        if (i & last_one_bit) a ^= i;
        else b ^= i;
    }
    return {a, b};
}
