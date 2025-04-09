#include <vector>

std::vector<std::vector<int>> ans;
int N;
int K;

void find(std::vector<int> & path, int i) {
    if (path.size() == K) {
        ans.push_back(path);
        return;
    }

    path.push_back(i);
    find(path, i + 1);
    path.pop_back();

    if (N - i >= K - path.size()) {
        find(path, i + 1);
    }
}

std::vector<std::vector<int>> combine(int n, int k) {
    ans.clear();
    N = n;
    K = k;
    std::vector<int> path;
    find(path, 1);
    return ans;
}
