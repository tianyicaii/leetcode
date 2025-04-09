#include <vector>

std::vector<std::vector<int>> subsets(std::vector<int>& nums) {

    std::vector<std::vector<int>> ans;
    int N = nums.size();
    int cnt = 1 << N;

    for (int i = 0; i < cnt; i++) {
        std::vector<int> subset;
        for (int j = 0; j < N; ++j) {
            if ((i >> j) & 1) {
                subset.push_back(nums[j]);
            }
        }
        ans.push_back(subset);
    }

    return ans;
}
