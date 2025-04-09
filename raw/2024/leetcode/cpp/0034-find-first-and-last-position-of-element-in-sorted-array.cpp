#include <vector>

template<typename T, typename V> T find_first(T b, T e, V t) {
    while (b < e) {
        T m = b + (e - b) / 2;
        if (*m < t) {
            b = m + 1;
        } else {
            e = m;
        }
    }
    return b;
}

template<typename T, typename V> T find_next_larger(T b, T e, V t) {
    while (b < e) {
        T m = b + (e - b) / 2;
        if (*m <= t) {
            b = m + 1;
        } else {
            e = m;
        }
    }
    return b;
}

std::vector<int> searchRange(std::vector<int>& nums, int target) {

    auto left = find_first<std::vector<int>::iterator, int>(nums.begin(), nums.end(), target);
    auto right = find_next_larger(nums.begin(), nums.end(), target);

    if (left != nums.end() && *left == target) {
        return {(int)(left - nums.begin()), (int)(right - nums.begin() - 1)};
    }
    return {-1, -1};
}
