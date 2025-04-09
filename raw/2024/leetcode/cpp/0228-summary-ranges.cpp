#include <string>
#include <vector>


std::string get_range(int start, int end) {
    if (start == end) { return std::to_string(start); }
    else return std::to_string(start) + "->" + std::to_string(end);
}

std::vector<std::string> summaryRanges(std::vector<int>& nums) {

    if (nums.empty()) return {};

    std::vector<std::string> ans;
    int start = nums[0];
    for (int i = 1; i < nums.size(); ++i) {
        if (nums[i] == nums[i-1] + 1) continue;
        else {
            ans.push_back(get_range(start, nums[i-1]));
            start = nums[i];
        }
    }

    ans.push_back(get_range(start, nums[nums.size()-1]));
    return ans;
}
