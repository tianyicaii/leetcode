package lintcode;

import java.util.Arrays;

public class I0443TwoSum2 {
    
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) left++;
            else {
                ans += (right - left);
                right --;
            }
        }
        return ans;
    }
}
