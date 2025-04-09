#include <algorithm>
#include <vector>

int jump(std::vector<int>& nums) {

    int L = 0;
    int R = 0;
    int A = 0;

    while (R < nums.size() - 1) {
        int J = 0;
        for (int i = L; i <= R; ++i) {
            J = std::max(J, nums[i] + i);
        }
        A += 1;
        L = R + 1;
        R = J;
    }

    return A;
}
