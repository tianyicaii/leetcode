#include <vector>

int majorityElement(std::vector<int>& nums) {

    int ans = nums[0];
    int cnt = 1;

    for (int i = 1; i < nums.size(); ++i) {
        if (nums[i] == ans) cnt += 1;
        else {
            if (cnt > 0) cnt -= 1;
            else {
                ans = nums[i];
                cnt = 1;
            }
        }
    }
    return ans;
}
