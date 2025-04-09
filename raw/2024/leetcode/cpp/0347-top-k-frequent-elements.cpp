#include <functional>
#include <map>
#include <queue>
#include <vector>


std::vector<int> topKFrequent(std::vector<int>& nums, int k) {

    std::map<int, int> cnt;
    for (int i : nums) {
        cnt[i] += 1;
    }
    std::priority_queue<int, std::vector<int>, std::function<bool(int, int)>> pq([&] (int a, int b) {
        return cnt[a] < cnt[b];
    });

    for (auto & i : cnt) {
        pq.push(i.first);
    }

    std::vector<int> ans;
    for (int i = 0; i < k; ++i) {
        ans.push_back(pq.top());
        pq.pop();
    }
    return ans;
}
