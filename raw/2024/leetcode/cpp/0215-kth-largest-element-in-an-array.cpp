#include <cstdlib>
#include <vector>


void swap(std::vector<int>::iterator left, std::vector<int>::iterator right) {
    int t = *left;
    *left = *right;
    *right = t;
}


int find(std::vector<int>::iterator b, std::vector<int>::iterator e, int rank) {

    int N = e - b;
    int p = rand() % N;
    swap(b, b + p);
    int pivot = *b;

    auto left = b;
    auto right = e;
    auto mid = b;

    while (mid < right) {

        if (*mid == pivot) { ++mid; }
        else if (*mid < pivot) {
            swap(left, mid);
            ++mid;
            ++left;
        }
        else {
            swap(mid, --right);
        }

    }
    int less_than = left - b;
    int equal_to = mid - left;
    // int greater_than = e - mid;

    if (rank < less_than) return find(b, left, rank);
    if (rank >= less_than + equal_to) return find(mid, e, rank - less_than - equal_to);
    return pivot;
}

int findKthLargest(std::vector<int>& nums, int k) {
    int N = nums.size();
    return find(nums.begin(), nums.end(), N-k);
}
