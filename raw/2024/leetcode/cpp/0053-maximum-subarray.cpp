#include <algorithm>
#include <utility>
#include <vector>

int maxSubArray(std::vector<int>& nums) {

    int curr_sub = nums[0];
    int max_seen = nums[0];

    for (auto i = nums.begin() + 1; i != nums.end(); ++i) {
        curr_sub = std::max(curr_sub + *i, *i);
        max_seen = std::max(max_seen, curr_sub);
    }
    return max_seen;

}





int sub(std::vector<int>::iterator b, std::vector<int>::iterator e) {
    if (e - b == 1) {
        return *b;
    }
    if (e - b == 2) {
        return std::max(std::max(*b, *(b+1)), (*b + *(b+1)));
    } 

    auto m = b + (e-b)/2;

    int max_left = 0;
    int max_right = 0;

    {
        auto curr = 0;
        auto i = m-1;
        while (true) {
            curr += *i;
            max_left = std::max(max_left, curr);
            if (i == b) { break; }
            --i;
        }
    }
    {
        auto curr = 0;
        auto i = m+1;
        while (i != e) {
            curr += *i;
            max_right = std::max(max_right, curr);
            ++i;
        }
    }

    int local_max = *m + max_left + max_right;

    if (m > b) {
        local_max = std::max(local_max, sub(b, m));
    }
    if (m+1 < e) {
        local_max = std::max(local_max, sub(m+1, e));
    }
    return local_max;
}


int maxSubArray_(std::vector<int>& nums) {
    return sub(nums.begin(), nums.end());
}