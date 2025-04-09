#include <climits>

bool is_overflow(int x_10, int d) {

    if (x_10 > INT_MAX / 10) { return true; }
    if (x_10 < INT_MIN / 10) { return true; }
    if (x_10 == INT_MAX && d > INT_MAX % 10) { return true; }
    if (x_10 == INT_MIN && d < INT_MIN % 10) { return true; }
    return false;
}

int reverse(int x) {

    int ans = 0;
    while (x != 0) {
        int d = x % 10;
        x = x / 10;
        if (is_overflow(ans, d)) { return 0; }
        ans = ans * 10 + d;
    }
    return ans;
}
