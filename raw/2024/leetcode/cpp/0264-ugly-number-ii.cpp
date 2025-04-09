#include <vector>

int nthUglyNumber(int n) {

    std::vector<int> nums = {1};

    int i_2 = 0;
    int i_3 = 0;
    int i_5 = 0;

    int v_2 = 2;
    int v_3 = 3;
    int v_5 = 5;

    for (int i = 2; i <= n; ++i) {

        int next = std::min(v_2, std::min(v_3, v_5));
        nums.push_back(next);

        if (next == v_2) {
            v_2 = nums[++ i_2] * 2;
        }
        if (next == v_3) {
            v_3 = nums[++ i_3] * 3;
        }
        if (next == v_5) {
            v_5 = nums[++ i_5] * 5;
        }
    }

    return nums.back();
}
