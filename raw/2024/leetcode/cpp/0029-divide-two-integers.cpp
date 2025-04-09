#include <climits>
#include <cstdlib>

int divide(int dividend, int divisor) {

    // overflow
    if (dividend == INT_MIN && divisor == -1) { return INT_MAX; }

    int sign = 1;
    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) { sign = -1; }

    long D = std::abs((long)dividend);
    long S = std::abs((long)divisor);
    long ans = 0;

    while (D >= S) {
        long val = S;
        long quo = 1;
        while (val <= D) {
            val <<= 1;
            quo <<= 1;
        }
        val >>= 1;
        quo >>= 1;
        ans += quo;
        D -= val;
    }

    return sign > 0 ? ans : -ans;
}
