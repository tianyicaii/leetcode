#include <deque>
#include <vector>

std::vector<int> maxSlidingWindow(std::vector<int>& nums, int k) {

    std::deque<int> window;
    std::vector<int> ans;
    int i = 0;
    while (i < nums.size()) {

        if (i >= k) {
            int left = nums[i-k];
            if (left == window.front()) window.pop_front();
        }

        int v = nums[i];
        while (!window.empty() && v > window.back()) {
            window.pop_back();
        };
        window.push_back(v);

        if (i >= k-1) {
            ans.push_back(window.front());
        }
        ++i;
    }


    return ans;
}