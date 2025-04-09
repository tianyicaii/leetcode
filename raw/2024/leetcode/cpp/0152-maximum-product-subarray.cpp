#include <algorithm>
#include <vector>

int maxProduct(std::vector<int>& nums) {

    int N = nums.size();
    int max_seen = nums[0];

    std::vector<int> min_vec(N);
    std::vector<int> max_vec(N);

    for (int i = 0; i < N; ++i) {

        if (i == 0) {
            min_vec[i] = nums[i];
            max_vec[i] = nums[i];
        } else {
            int min_v = nums[i];
            min_v = std::min(min_v, nums[i] * min_vec[i-1]);
            min_v = std::min(min_v, nums[i] * max_vec[i-1]);
            min_vec[i] = min_v;

            int max_v = nums[i];
            max_v = std::max(max_v, nums[i] * max_vec[i-1]);
            max_v = std::max(max_v, nums[i] * min_vec[i-1]);
            max_vec[i] = max_v;
        }
        max_seen = std::max(max_seen, max_vec[i]);
    }
    return max_seen;
}
