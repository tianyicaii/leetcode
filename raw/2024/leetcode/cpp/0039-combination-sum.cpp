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

    int c = C[i];
    int acc = sum(path);
    find(i + 1, path);  // choose 0 times 
    while (acc + c <= T) {  // choose 1 or more times
        path.push_back(c);
        acc += c;
        find(i + 1, path);
    }
}


std::vector<std::vector<int>> combinationSum(std::vector<int>& candidates, int target) {

    A.clear();
    C = candidates;
    T = target;
    find(0, std::vector<int>());
    return A;
}
