package lintcode;

public class I0539MoveZeros {
    
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int z = 0;
        while (z < N && nums[z] != 0) z++;
        int i = z+1;
        while (i < N) {
            if (nums[i] != 0) swap(nums, i, z++);
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
