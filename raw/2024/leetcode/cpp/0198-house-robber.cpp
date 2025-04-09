#include <algorithm>
#include <vector>

int rob(std::vector<int>& nums) {

    int N = nums.size();
    std::vector<int> dp(N+1);

    for (int i = 0; i <= N; ++i) {

        if (i == 0) dp[i] = 0;
        else if (i == 1) dp[i] = nums[i-1];
        else dp[i] = std::max(nums[i-1] + dp[i-2], dp[i-1]);
    }

    return dp[N];
}
