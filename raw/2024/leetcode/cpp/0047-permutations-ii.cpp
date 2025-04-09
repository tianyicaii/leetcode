#include <algorithm>
#include <vector>

std::vector<std::vector<int>> A;
std::vector<int> C;
std::vector<bool> F;

void gen(std::vector<int> path) {

    if (path.size() == C.size()) {
        A.push_back(path);
        return;
    }

    int prev_idx = -1;
    for (int i = 0; i < C.size(); ++i) {
        if (F[i]) { continue; }

        if (prev_idx != -1 && C[i] == C[prev_idx]) { continue; }

        path.push_back(C[i]);
        F[i] = true;
        gen(path);
        F[i] = false;
        path.pop_back();

        prev_idx = i;
    }
}

std::vector<std::vector<int>> permuteUnique(std::vector<int>& nums) {
    std::sort(nums.begin(), nums.end());
    A.clear();
    C = nums;
    F = std::vector<bool>(C.size(), false);
    gen(std::vector<int>());
    return A;
}
