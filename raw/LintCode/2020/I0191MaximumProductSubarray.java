package lintcode;

public class I0191MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int N = nums.length;
        int[] max = new int[N];
        int[] min = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                max[i] = nums[i];
                min[i] = nums[i];
            } else {
                max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
                min[i] = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i-1]));
            }
        }

        int ans = max[0];
        for (int i : max) ans = Math.max(ans, i);
        return ans;
    }

}
