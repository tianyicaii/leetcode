#include <algorithm>
#include <utility>
#include <vector>

int maximumGap(std::vector<int>& nums) {

    int N = nums.size();
    if (N <= 1) return 0;

    int min_v = nums[0];
    int max_v = nums[0];

    for (int i : nums) {
        min_v = std::min(min_v, i);
        max_v = std::max(max_v, i);
    }

    if (min_v == max_v) return 0;

    int range = max_v - min_v;
    int bucket_size = range / (N-1);
    if (range % (N-1)) bucket_size += 1;

    std::vector<std::pair<int, bool>> min_b(N, {0, false});
    std::vector<std::pair<int, bool>> max_b(N, {0, false});

    for (int i : nums) {
        int bucket = (i - min_v) / bucket_size;

        if (!min_b[bucket].second) {
            min_b[bucket] = {i, true};
            max_b[bucket] = {i, true};
        } else {
            min_b[bucket].first = std::min(i, min_b[bucket].first);
            max_b[bucket].first = std::max(i, max_b[bucket].first);
        }
    }

    int ans = 0;
    int prev_max = max_b[0].first;
    for (int i = 1; i < N; ++i) {
        if (min_b[i].second) {
            ans = std::max(ans, min_b[i].first - prev_max);
            prev_max = max_b[i].first;
        }
    }
    return ans;
}
