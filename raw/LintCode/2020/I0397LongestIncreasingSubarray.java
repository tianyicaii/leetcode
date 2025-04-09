package lintcode;

public class I0397LongestIncreasingSubarray {
    
    public int longestIncreasingContinuousSubsequence(int[] A) {

        if (A.length == 0) return 0;
        int max = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                inc ++;
                dec = 1;
            } else if (A[i] < A[i-1]){
                inc = 1;
                dec ++;   
            } else {
                inc ++;
                dec ++;
            }
            max = Math.max(max, Math.max(inc, dec));
        }
        return max;
    }
}
