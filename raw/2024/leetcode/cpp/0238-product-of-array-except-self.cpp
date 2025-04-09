#include <vector>

std::vector<int> productExceptSelf(std::vector<int>& nums) {

    int N = nums.size();
    std::vector<int> ans(N, 1);
    std::vector<int> L(N, 1);
    std::vector<int> R(N, 1);

    for (int i = 1; i < N; i++) {
        L[i] = L[i-1] * nums[i-1];
    }
    for (int i = N-2; i >= 0; i--) {
        R[i] = R[i+1] * nums[i+1];
    }
    for (int i = 0; i < N; i++) {
        ans[i] = L[i] * R[i];
    }

    return ans;
}
