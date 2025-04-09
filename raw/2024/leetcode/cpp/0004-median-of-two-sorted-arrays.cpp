
#include <algorithm>
#include <cstddef>
#include <vector>

int find_kth(std::vector<int>::iterator begin_a, std::vector<int>::iterator end_a, std::vector<int>::iterator begin_b, std::vector<int>::iterator end_b, int k) {

    size_t size_a = end_a - begin_a;
    size_t size_b = end_b - begin_b;

    if (size_a == 0) {
        return *(begin_b + k);
    }
    if (size_b == 0) {
        return *(begin_a + k);
    }
    if (k == 0) {
        return std::min(*begin_a, *begin_b);
    }

    auto p_a = begin_a + std::min((int)(size_a - 1), (k + 1)/2 - 1);
    auto p_b = begin_b + std::min((int)(size_b - 1), (k + 1)/2 - 1);
    if (*p_a < *p_b) {
        return find_kth(p_a + 1, end_a, begin_b, end_b, k - (p_a - begin_a + 1));
    } else {
        return find_kth(begin_a, end_a, p_b + 1, end_b, k - (p_b - begin_b + 1));
    }
}


double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {

    int len = nums1.size() + nums2.size();
    if (len % 2 == 1) {
        return find_kth(nums1.begin(), nums1.end(), nums2.begin(), nums2.end(), len / 2);
    } else {
        return (find_kth(nums1.begin(), nums1.end(), nums2.begin(), nums2.end(), len / 2 - 1) + find_kth(nums1.begin(), nums1.end(), nums2.begin(), nums2.end(), len / 2)) / 2.0;
    }
}
