#include <algorithm>
#include <vector>


int get(std::vector<int>& nums, int i) {
    if (i < 0) return 1;
    if (i == nums.size()) return 1;
    return nums[i];
}


int maxCoins(std::vector<int>& nums) {
    int N = nums.size();
    std::vector<std::vector<int>> dp(N + 1, std::vector<int>(N));

    for (int len = 1; len <= N; ++len) {
        for (int start = 0; start + len <= N; ++start) {

            if (len == 1) {
                dp[len][start] = get(nums, start - 1) * get(nums, start) * get(nums, start + 1);
            }
            else {
                dp[len][start] = std::max(
                    get(nums, start - 1) * get(nums, start) * get(nums, start + len) + dp[len - 1][start + 1],
                    get(nums, start - 1) * get(nums, start + len - 1) * get(nums, start + len) + dp[len - 1][start]
                );

                for (int split = start + 1; split < start + len - 1; ++split) {
                    dp[len][start] = std::max(dp[len][start], 
                            dp[split - start][start] +
                            get(nums, start - 1) * get(nums, split) * get(nums, start + len) +
                            dp[len - (split - start + 1)][split + 1]
                    );
                }
            }
        }
    }

    return dp[N][0];
}
