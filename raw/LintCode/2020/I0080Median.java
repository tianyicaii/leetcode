package lintcode;


public class I0080Median {

    public int median(int[] nums) {

        int beg = 0;
        int end = nums.length;
        int k = (nums.length - 1) / 2;

        while (beg < end) {
            int[] parts = p3(nums, beg, end);
            if (k >= parts[0] && k < parts[1]) return nums[parts[0]];
            if (k < parts[0]) end = parts[0];
            else beg = parts[1];
        }

        throw new IllegalArgumentException();
    }
    
    private int[] p3(int[] nums, int beg, int end) {
        int p = (int)(Math.random() * (end - beg) + beg);
        swap(nums, beg, p);

        int x = beg + 1;
        while (x < end) {
            if (nums[x] < nums[beg]) swap(nums, beg++, x++);
            else if (nums[x] > nums[beg]) swap(nums, x, --end);
            else x++;
        }
        return new int[] {beg, x};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
