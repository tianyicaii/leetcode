#include <vector>

int search(std::vector<int>& nums, int target) {

    auto b = nums.begin();
    auto e = nums.end();

    while (b < e) {
        auto m = b + (e - b) / 2;

        if (*m == target) { return m - nums.begin(); }

        if (*b < *m) {
            if (*b <= target && target < *m) { e = m; }
            else { b = m + 1; }
        } else {
            if (*b <= target) { e = m; }
            else if ( target < *m ) { e = m; }
            else { b = m + 1; }
        }
    }

    return -1;
}
