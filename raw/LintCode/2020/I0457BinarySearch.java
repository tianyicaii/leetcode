package lintcode;

public class I0457BinarySearch {
    
    public int findPosition(int[] nums, int target) {

        int l = 0;
        int r = nums.length;

        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) r = m;
            else l = m; 
        }

        if (l == nums.length) return -1;
        if (nums[l] == target) return l;
        return -1;
    }
}
