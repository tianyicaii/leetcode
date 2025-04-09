#include <map>
#include <vector>

std::vector<std::vector<int>> subsetsWithDup(std::vector<int>& nums) {

    std::vector<std::vector<int>> ans{{}};
    std::map<int, int> cnt;
    for (int i : nums) {
        ++cnt[i];
    }
    for (const auto i : cnt) {
        int v = i.first;
        int c = i.second;

        int sz = ans.size();
        for (int x = 0; x < c; x++) {
            for (int s = x * sz; s < (x + 1) * sz; s++) {
                auto p = ans[s];
                p.push_back(v);
                ans.push_back(p);
            }
        }
    }
    return ans;

}
