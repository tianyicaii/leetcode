#include <vector>

int missingNumber(std::vector<int>& nums) {

    int N = nums.size();

    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] == i) continue;
        if (nums[i] == N) continue;
        int j = nums[i];
        while (true) {
            int v = nums[j];
            nums[j] = j;
            j = v;
            if (v == N || nums[j] == j) break;
        }
    }

    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] != i) return i;
    }
    return N;
}
