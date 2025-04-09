package lintcode;

import java.util.Arrays;

public class I0533TwoSumClosest {
    
    public int twoSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];
            diff = Math.min(diff, Math.abs(sum - target));
            if (sum == target) return 0;
            if (sum > target) right --;
            else left ++;
        }
        return diff;
    }
}
