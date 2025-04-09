package lintcode;

public class I0045MaximumSubarrayDifference {

    public int maxDiffSubArrays(int[] nums) {

        int[] leftMax = findM(nums, true);
        int[] leftMin = findM(nums, false);
        reverse(nums);
        int[] rightMax = findM(nums, true);
        int[] rightMin = findM(nums, false);

        int ans = -1;
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, leftMax[i] - rightMin[N-i]);
            ans = Math.max(ans, rightMax[i] - leftMin[N-i]);
        }
        return ans;
    }

    private int[] findM(int[] nums, boolean max) {
        int N = nums.length;
        int[] local = new int[N + 1];
        int[] global = new int[N + 1];
        local[1] = nums[0];
        global[1] = nums[0];
        for (int i = 2; i <= N; i++) {
            if (max) {
                local[i] = Math.max(nums[i-1], local[i-1] + nums[i-1]);
                global[i] = Math.max(global[i-1], local[i]);    
            } else {
                local[i] = Math.min(nums[i-1], local[i-1] + nums[i-1]);
                global[i] = Math.min(global[i-1], local[i]);    
            }
        }
        return global;
    }

    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


