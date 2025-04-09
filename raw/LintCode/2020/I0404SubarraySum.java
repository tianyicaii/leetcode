package lintcode;

public class I0404SubarraySum {
    
    public int subarraySumII(int[] A, int start, int end) {
        int N = A.length;
        if (N == 0) return 0;
        int beg = 0;
        int end1 = 1;
        int end2 = 1;
        int sum1 = A[0];
        int sum2 = A[0];
        int ans = 0;

        while (beg < N) {

            if (end1 == beg) {
                sum1 += A[end1];
                end1 += 1;
            }
            while (end1 < N && sum1 < start) {
                sum1 += A[end1];
                end1 += 1;
            }

            if (end2 == beg) {
                sum2 += A[end2];
                end2 += 1;
            }
            while (end2 < N && sum2 <= end) {
                sum2 += A[end2];
                end2 += 1;
            }

            if (sum1 < start) break;
            if (sum2 <= end) ans += (end2 - end1 + 1);
            else ans += (end2 - end1);

            sum1 -= A[beg];
            sum2 -= A[beg];
            beg += 1;
        }

        return ans;
    }



    public int subarraySumII_(int[] A, int start, int end) {
        int N = A.length;
        int[] ps = new int[N+1];
        for (int i = 1; i <= N; i++) ps[i] = ps[i-1] + A[i-1];
        
        int E = 1;
        int L = 0;
        int R = 0;
        int ans = 0;

        while (E <= N) {
            while (R < E && (ps[E]-ps[R]) >= start) R++;
            while (L < E && (ps[E]-ps[L]) > end) L++;
            ans += (R-L);
            E ++;
        }
        return ans;
    }



    int N;
    int[] ps;

    // find first index such that ps[index] >= a
    private int ceiling(int i, int minSum) {
        int left = 0;
        int right = i;
        if (ps[left] >= minSum) return left;
        while (left < right - 1) {
            int mid = (right - left)/2 + left;
            if (ps[mid] < minSum) left = mid;
            else right = mid;
        }
        return right;
    }
    
    public int subarraySumII__(int[] A, int start, int end) {
        N = A.length;
        ps = new int[N+1];
        for (int i = 1; i <= N; i++) ps[i] = ps[i-1] + A[i-1];
        int ans = 0;
        for (int i = 1; i <= N; i++) ans += ceiling(i, ps[i] - start + 1) - ceiling(i, ps[i] - end);
        return ans;
    }
}
