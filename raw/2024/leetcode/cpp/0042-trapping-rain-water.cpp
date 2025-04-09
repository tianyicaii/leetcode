#include <vector>

int trap(std::vector<int>& heights) {
    if (heights.size() <= 2) { return 0; }
    auto left = heights.begin();
    auto right = heights.end() - 1;
    auto L = *left;
    auto R = *right;
    int ans = 0;
    while (left <= right) {
        if (L < R) {
            if (*left < L) { ans += (L - *left); }
            else { L = *left; }
            ++ left;
        } else {
            if (*right < R) { ans += (R - *right); }
            else { R = *right; }
            -- right;
        }
    }
    return ans;
}
