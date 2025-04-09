package lintcode;

public class I0148SortColors {

    public void sortColors(int[] nums) {

        int left = -1;
        int right = nums.length;
        int x = 0;

        while (x < right) {
            if (nums[x] == 1) x++;
            else if (nums[x] == 0) swap(nums, ++left, x++);
            else swap(nums, x, --right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
