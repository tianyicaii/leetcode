package lintcode;

public class I0031PartitionArray {
    public int partitionArray(int[] nums, int k) {
        int left = -1;
        int right = nums.length;
        int x = 0;
        while (x < right) {
            if (nums[x] == k) x++;
            else if (nums[x] < k) swap(nums, ++left, x++);
            else swap(nums, --right, x);
        }
        return left + 1; 
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
