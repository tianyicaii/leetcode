#include <vector>


void find(std::vector<std::vector<int>> & ans, std::vector<int> & path, int f, int n) {
    if (n == 1 && path.size() > 1) {
        ans.push_back(path);
        return;
    }

    for (; f <= n; ++f) {
        if (n % f) continue;
        path.push_back(f);
        find(ans, path, f, n/f);
        path.pop_back();
    }
}


std::vector<std::vector<int>> getFactors(int n) {
    if (n <= 1) return {};
    std::vector<std::vector<int>> ans;
    std::vector<int> path;
    find(ans, path, 2, n);
    return ans;
}