package lintcode;

public class I0159FindMinimumInRotatedSortedArray {
    
    public int findMin(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums[0];
        if (nums[0] < nums[N-1]) return nums[0];

        int left = 0;
        int right = N-1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) left = mid;
            else right = mid;
        }

        return nums[right];
    }

}
