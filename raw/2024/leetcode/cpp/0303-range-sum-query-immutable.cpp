#include <vector>


class NumArray {

    std::vector<int> presum;

public:

    NumArray(std::vector<int>& nums) {
        int sum = 0;
        presum.push_back(0);
        for (int i : nums) {
            sum += i;
            presum.push_back(sum);
        }
    }
    
    int sumRange(int left, int right) {
        int presum_left = presum[left];
        int presum_right = presum[right + 1];
        return presum_right - presum_left;
    }
};
