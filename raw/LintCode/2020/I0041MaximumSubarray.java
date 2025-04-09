package lintcode;

public class I0041MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int[] local = new int[N];
        int[] global = new int[N];

        local[0] = nums[0];
        global[0] = nums[0];

        for (int i = 1; i < N; i++) {
            local[i] = Math.max(local[i-1] + nums[i], nums[i]);
            global[i] = Math.max(global[i-1], local[i]);
        }

        return global[N-1];
    }


    public int maxSubArray_(int[] nums) {
        return dc(nums, 0, nums.length);
    }
    private int dc(int[]nums, int left, int right) {

        if (right - left == 1) return nums[left];
        if (right - left == 2) return Math.max(Math.max(nums[left], nums[left + 1]), nums[left] + nums[left + 1]);

        int mid = (right - left) / 2 + left;
        int leftHalfMaxSum = 0;
        int rightHalfMaxSum = 0; 
        for (int i = mid - 1, sum = 0; i >= left; i--) {
            sum += nums[i];
            leftHalfMaxSum = Math.max(sum, leftHalfMaxSum);
        }
        for (int i = mid + 1, sum = 0; i < right; i++) {
            sum += nums[i];
            rightHalfMaxSum = Math.max(sum, rightHalfMaxSum);
        }

        return Math.max(Math.max(dc(nums, left, mid), dc(nums, mid + 1, right)), leftHalfMaxSum + nums[mid] + rightHalfMaxSum);
    }

    public int maxSubArray__(int[] nums) {
        int N = nums.length;
        int[] prefixSum = new int[N + 1];
        int[] prefixMin = new int[N + 1];
        int max = nums[0];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            prefixMin[i] = Math.min(prefixMin[i-1], prefixSum[i]);
            max = Math.max(max, prefixSum[i] - prefixMin[i-1]);
        }
        return max;
    }

}
