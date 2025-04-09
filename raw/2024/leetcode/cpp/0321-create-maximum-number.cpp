#include <algorithm>
#include <cassert>
#include <stack>
#include <vector>



std::vector<int> choose(std::vector<int> & nums, int len) {

    std::vector<int> ans(len);
    std::stack<int> cand;
    assert(nums.size() >= len);

    int num_to_drop = nums.size() - len;
    for (int i = 0; i < nums.size(); ++i) {
        int x = nums[i];
        while (!cand.empty() && num_to_drop > 0 && cand.top() < x) { cand.pop(); num_to_drop -= 1; }
        if (cand.size() < len) { cand.push(x); }
        else { num_to_drop -= 1; }
    }

    for (int i = len-1; i >= 0; --i) {
        ans[i] = cand.top();
        cand.pop();
    }
    return ans;
}


bool is_greater(std::vector<int> & nums1, int i, std::vector<int> & nums2, int j) {

    while (i < nums1.size() && j < nums2.size()) {
        if (nums1[i] < nums2[j]) return false;
        if (nums1[i] > nums2[j]) return true;
        ++i; ++j;
    }
    return (i != nums1.size()) ? true : false;
}


std::vector<int> merge(std::vector<int> & nums1, std::vector<int> & nums2) {

    std::vector<int> ans;
    int i = 0;
    int j = 0;
    while (i < nums1.size() && j < nums2.size()) {
        if (is_greater(nums1, i, nums2, j)) {
            ans.push_back(nums1[i++]);
        } else {
            ans.push_back(nums2[j++]);
        }
    }
    while (i < nums1.size()) {
        ans.push_back(nums1[i++]);
    }
    while (j < nums2.size()) {
        ans.push_back(nums2[j++]);
    }
    return ans;
}


std::vector<int> maxNumber(std::vector<int>& nums1, std::vector<int>& nums2, int k) {


    int min_len_1 = std::max(0, k-(int)nums2.size());
    int max_len_1 = std::min((int)nums1.size(), k);
    std::vector<int> ans;

    for (int len_1 = min_len_1; len_1 <= max_len_1; ++len_1) {
        int len_2 = k - len_1;
        std::vector<int> seq_1 = choose(nums1, len_1);
        std::vector<int> seq_2 = choose(nums2, len_2);
        std::vector<int> merged = merge(seq_1, seq_2);
        if (is_greater(merged, 0, ans, 0)) ans = merged;
    }
    return ans;
}
