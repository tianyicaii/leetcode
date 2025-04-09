#include <algorithm>
#include <numeric>
#include <vector>

std::vector<std::vector<int>> A;
std::vector<int> C;
int T;

int sum(std::vector<int> & nums) {
    return std::accumulate(nums.begin(), nums.end(), 0);
}

void find(int i, std::vector<int> path) {
    if (i == C.size()) {
        if (sum(path) == T) {
            A.push_back(path);
        }
        return;
    }

    int j = i + 1;
    while (j != C.size() && C[i] == C[j]) j++;
    find(j, path);
    if (sum(path) + C[i] <= T) {
        path.push_back(C[i]);
        find(i + 1, path); 
    }
}

std::vector<std::vector<int>> combinationSum2(std::vector<int>& candidates, int target) {
    std::sort(candidates.begin(), candidates.end());
    A.clear();
    C = candidates;
    T = target;
    find(0, std::vector<int>());
    return A;
}
