package lintcode;

public class I0458LastPosition {

    public int lastPosition(int[] nums, int target) {

        int beg = 0;
        int end = nums.length;

        while (beg < end - 1) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] <= target) beg = mid;
            else end = mid; 
        }

        if (beg == end) return -1;
        if (nums[beg] == target) return beg;
        return -1;
    }
}
