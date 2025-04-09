package lintcode;

public class I0438CopyBooks2 {
    
    public int copyBooksII(int n, int[] times) {

        int left = 0;
        int right = Integer.MAX_VALUE;
        for (int t : times) right = Math.min(right, n * t);

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isValid(n, times, mid)) right = mid;
            else left = mid; 
        }
        return right;
    }

    boolean isValid(int n, int[] times, int guess) {
        int cnt = 0;
        for (int t : times) {
            cnt += guess / t;
        }
        return cnt >= n;
    }
}
