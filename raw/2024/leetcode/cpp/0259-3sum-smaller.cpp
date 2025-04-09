#include <algorithm>
#include <vector>


int b_search(std::vector<int>& nums, int b, int target) {
    int e = nums.size();
    while (b < e) {
        int m = b + (e - b) / 2;
        if (nums[m] >= target) e = m;
        else b = m + 1;
    }
    return b-1;
}


int threeSumSmaller(std::vector<int>& nums, int target) {
    if (nums.size() < 3) return 0;
    std::sort(nums.begin(), nums.end());
    int ans = 0;
    for (int i = 0; i < nums.size() - 2; ++i) {
        for (int j = i + 1; j < nums.size() - 1; ++j) {
            int k = b_search(nums, j + 1, target - nums[i] - nums[j]);
            if (k > j) ans += (k - j);
        }
    }
    return ans;
}
