package lintcode;

import java.util.Arrays;

public class I0521DedupArray {

    public int deduplication(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int last = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i-1]) nums[++last] = nums[i++];
            else i++;
        }
        return last + 1;
    }
}
