#include <vector>


std::vector<std::vector<int>> A;
std::vector<int> C;
std::vector<bool> F;


void gen(std::vector<int> path) {

    if (path.size() == C.size()) {
        A.push_back(path);
        return;
    }
    for (int i = 0; i < C.size(); ++i) {
        if (F[i]) { continue; }
        F[i] = true;
        path.push_back(C[i]);
        gen(path);
        F[i] = false;
        path.pop_back();
    }
}

std::vector<std::vector<int>> permute(std::vector<int>& nums) {

    A.clear();
    C = nums;
    F = std::vector<bool>(C.size());
    gen(std::vector<int>());
    return A;

}
