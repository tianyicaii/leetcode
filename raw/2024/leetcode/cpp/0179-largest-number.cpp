#include <algorithm>
#include <string>
#include <vector>

std::string largestNumber(std::vector<int>& nums) {

    std::sort(nums.begin(), nums.end(), [](int a, int b) -> bool {
        std::string x = std::to_string(a);
        std::string y = std::to_string(b);
        return x + y < y + x;
    });

    if (nums.back() == 0) { return "0"; }
    std::string ans;
    std::for_each(nums.rbegin(), nums.rend(), [&ans](int x) { ans += (std::to_string(x)); } );
    return ans;
}
