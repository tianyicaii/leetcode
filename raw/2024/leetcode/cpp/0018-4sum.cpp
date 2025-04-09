#include <algorithm>
#include <vector>



std::vector<std::vector<int>> two_sum(std::vector<int>::iterator left, std::vector<int>::iterator right, long long target) {
    std::vector<std::vector<int>> ans;
    while (left < right) {
        if (*left + *right < target) {
            ++ left;
        } else if (*left + *right > target) {
            -- right;
        }
        else {
            ans.push_back({ *left, *right});
            ++ left;
            -- right;
            while (left < right && *left == *(left - 1)) { ++ left; }
            while (left < right && *right == *(right + 1)) { -- right; }
        }
    }
    return ans;
}

std::vector<std::vector<int>> k_sum(std::vector<int>::iterator b, std::vector<int>::iterator e, long long target, int k) {
    if (e - b < k) {
        return {};
    }
    if (k == 2) {
        return two_sum(b, e-1, target);
    }
    std::vector<std::vector<int>> ans;

    while (e - b >= k) {

        auto sub_ans = k_sum(b+1, e, target-(*b), k-1);
        for (auto & e : sub_ans) {
            std::vector<int> ek = {*b};
            ek.insert(ek.end(), e.begin(), e.end());
            ans.push_back(ek);
        }

        ++ b;
        while (e - b >= k && *b == *(b-1)) { ++ b; }
    }

    return ans;
}

std::vector<std::vector<int>> fourSum(std::vector<int>& nums, int target) {
    std::sort(nums.begin(), nums.end());
    return k_sum(nums.begin(), nums.end(), target, 4);
}
