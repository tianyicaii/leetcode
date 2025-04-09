#include <vector>


void merge(std::vector<long long> & v, int b, int e, int mid) {

    std::vector<long long> ans;
    int i = b;
    int j = mid;
    while (i < mid && j < e) {
        if (v[i] <= v[j]) ans.push_back(v[i++]);
        else ans.push_back(v[j++]);
    }
    while (i < mid) {
        ans.push_back(v[i++]);
    }
    while (j < e) {
        ans.push_back(v[j++]);
    }
    for (auto i : ans) {
        v[b++] = i;
    }
}


int merge_sort(std::vector<long long> & v, int b, int e, int lower, int upper) {
    if (b == e - 1) {
        if (v[b] >= lower && v[b] <= upper) return 1;
        return 0;
    }

    int mid = b + (e - b) / 2;
    int L = merge_sort(v, b, mid, lower, upper);
    int R = merge_sort(v, mid, e, lower, upper);

    int i = mid;
    int j = mid;
    int cnt = 0;
    for (int k = b; k < mid; ++k) {
        while (i < e && v[i] - v[k] < lower) ++i;
        while (j < e && v[j] - v[k] <= upper) ++j;
        cnt += j - i;
    }

    merge(v, b, e, mid);
    return cnt + L + R;
}


int countRangeSum(std::vector<int>& nums, int lower, int upper) {

    std::vector<long long> prefix;
    long long sum = 0;
    for (int i = 0; i < nums.size(); ++i) {
        sum += nums[i];
        prefix.push_back(sum);
    }
    return merge_sort(prefix, 0, prefix.size(), lower, upper);
}
