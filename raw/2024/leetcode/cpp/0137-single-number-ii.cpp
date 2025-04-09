#include <vector>

int singleNumber(std::vector<int>& nums) {

    int bits[32] {0,};

    for (int v : nums) {
        for (int i = 0; i < 32; ++i) {
            if (v & (1 << i)) bits[i] = (bits[i] + 1) % 3;
        }
    }

    int ans = 0;
    for (int i = 0; i < 32; ++i) {
        if (bits[i]) ans = ans | (1 << i);
    }
    return ans;
}
