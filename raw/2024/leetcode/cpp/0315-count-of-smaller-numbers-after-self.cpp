#include <utility>
#include <vector>


void merge(std::vector<int> & cnts, std::vector<std::pair<int, int>> & pairs, int b, int e, int mid) {

    std::vector<std::pair<int, int>> ans;
    int i = b;
    int j = mid;
    int ooo = 0;
    while (i < mid && j < e) {
        if (pairs[i].second <= pairs[j].second) {
            cnts[pairs[i].first] += ooo;
            ans.push_back(pairs[i++]);
        }
        else {
            ooo += 1;
            ans.push_back(pairs[j++]);
        }
    }
    while (i < mid) {
        cnts[pairs[i].first] += ooo;
        ans.push_back(pairs[i++]);
    }
    while (j < e) {
        ans.push_back(pairs[j++]);
    }
    for (auto p : ans) {
        pairs[b++] = p;
    }
}


void merge_sort(std::vector<int> & cnts, std::vector<std::pair<int, int>> & pairs, int b, int e) {
    if (b == e - 1) {
        return;
    }
    int mid = b + (e - b) / 2;
    merge_sort(cnts, pairs, b, mid);
    merge_sort(cnts, pairs, mid, e);
    merge(cnts, pairs, b, e, mid);
}


std::vector<int> countSmaller(std::vector<int>& nums) {
    int N = nums.size();
    if (N == 0) return {};
    std::vector<int> ans(N);
    std::vector<std::pair<int, int>> pairs;
    for (int i = 0; i < nums.size(); ++i) {
        pairs.push_back({i, nums[i]});
    }
    merge_sort(ans, pairs, 0, N);
    return ans;
}
