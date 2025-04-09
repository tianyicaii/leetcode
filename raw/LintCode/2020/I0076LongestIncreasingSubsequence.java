package lintcode;

import java.util.Arrays;

public class I0076LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];  // dp[i] longest including nums[i]
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    // relaxation
    public int longestIncreasingSubsequence_(int[] nums) {

        int N = nums.length;
        int[] A = new int[N];
        int lenA = 0;
        for (int i = 0; i < N; i++) {
            int p = ceiling(A, lenA, nums[i]);
            A[p] = nums[i];
            lenA = Math.max(lenA, p + 1);
        }
        return lenA;
    }

    private int ceiling(int[] A, int end, int k) {
        if (end == 0) return 0;
        if (A[0] > k) return 0;
        if (A[end - 1] < k) return end;

        int left = 0;
        int right = end;
        while (left < right - 1) {
            int mid = (right - left) / 2 + left;
            if (A[mid] <= k) left = mid;
            else right = mid;
        }
        return A[left] == k ? left : left + 1;
    }
}
