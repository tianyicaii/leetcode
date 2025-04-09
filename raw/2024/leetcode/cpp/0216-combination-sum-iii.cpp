#include <vector>



void find(std::vector<std::vector<int>> & ans, int num, int target, std::vector<int> path) {
    if (num == 0 && target == 0) {
        ans.push_back(path);
    }
    if (num == 0 || target == 0) {
        return;
    }

    int i = 1;
    if (!path.empty()) i = path.back() + 1;

    for (; i <= 9; ++i) {
        path.push_back(i);
        find(ans, num-1, target-i, path);
        path.pop_back();
    }
}


std::vector<std::vector<int>> combinationSum3(int k, int n) {
    std::vector<std::vector<int>> ans;
    std::vector<int> path;
    find(ans, k, n, path);
    return ans;
}
