package lintcode;

import java.util.Random;

public class I0461SelectKth {
    

    public int kthSmallest(int k, int[] nums) {

        k -= 1;
        int N = nums.length;
        if (k >= N || k < 0) throw new IllegalArgumentException();

        Random r = new Random();
        int beg = 0;
        int end = nums.length;

        while (true) {
            int p = beg + (int)((end - beg) * r.nextDouble());
            int[] equalRange = p3(nums, p, beg, end);
            if (k < equalRange[0]) end = equalRange[0];
            else if (k >= equalRange[1]) beg = equalRange[1];
            else return nums[equalRange[0]];
        }
    }


    int[] p3(int[] nums, int p, int beg, int end) {
        swap(nums, beg, p);
        int x = beg + 1;
        int P = nums[beg];
        while (x < end) {
            if (nums[x] == P) x++;
            else if (nums[x] < P) swap(nums, beg++, x++);
            else swap(nums, x, --end);
        }
        return new int[] {beg, end};
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
