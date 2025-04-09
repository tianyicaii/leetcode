#include <set>
#include <vector>

std::vector<int> intersection(std::vector<int>& nums1, std::vector<int>& nums2) {

    std::set<int> s1(nums1.begin(), nums1.end());
    std::set<int> s2(nums2.begin(), nums2.end());
    std::vector<int> ans;
    for (auto i : s1) {
        if (s2.count(i)) ans.push_back(i);
    }
    return ans;
}
