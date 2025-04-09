package lintcode;

public class I0406MinSizeSubarraySum {
    

    public int minimumSize(int[] nums, int s) {

        int beg = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int N = nums.length;

        while (end < N) {
            while (end < N && sum < s) sum += nums[end++];
            while (beg < end && sum >= s) {
                ans = Math.min(ans, end-(beg));
                sum -= nums[beg++];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
