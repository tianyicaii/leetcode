#include <cstdint>

uint32_t reverseBits(uint32_t n) {

    uint32_t ans = 0;

    for (int i = 0; i < 32; ++i) {
        int d = (1 << i) & n;
        ans <<= 1;
        if (d) ans |= 1;
    }
    return ans;
}
