#include <algorithm>
#include <vector>


int lengthOfLIS(std::vector<int>& nums) {

    int max = 0;
    int N = nums.size();
    std::vector<int> dp(N+1, 0);
    for (int i = 0; i <= N; ++i) {
        if (i == 0) dp[i] = 0;
        else {
            dp[i] = 1;
            for (int j = i - 2; j >= 0; --j) {
                if (nums[i-1] > nums[j]) {
                    dp[i] = std::max(dp[i], dp[j+1] + 1);
                }
            }
            max = std::max(max, dp[i]);
        }
    }
    return max;
}


int b_search(int b, int e, int v, std::vector<int> & nums) {

    if (nums[b] >= v) return b;
    while (b < e - 1) {
        int mid = b + (e - b)/2;
        if (nums[mid] < v) b = mid;
        else e = mid;
    }
    return b + 1;
}


int lengthOfLIS_(std::vector<int>& nums) {
    if (nums.empty()) return 0;
    int len = 1;
    for (int i = 1; i < nums.size(); ++i) {
        int x = b_search(0, len, nums[i], nums);
        nums[x] = nums[i];
        if (x == len) {
            len += 1;
        }
    }
    return len;
}
