package lintcode;

public class I0460KClosest {
    
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int N = A.length;
        if (k > N) k = N;
        int[] ans = new int[k];
        if (N == 0) return ans;


        int left = floor(A, target);
        int right = left + 1;

        for (int i = 0; i < k; i++) {
            if (left < 0) ans[i] = A[right++];
            else if (right == N) ans[i] = A[left--];
            else if (Math.abs(target - A[left]) <= Math.abs(target - A[right])) ans[i] = A[left--];
            else ans[i] = A[right++];
        }

        return ans;
    }

    private int floor(int[] A, int target) {
        int beg = 0;
        int end = A.length;

        while (beg < end - 1) {
            int mid = beg + (end - beg) / 2;
            if (A[mid] >= target) end = mid;
            else beg = mid; 
        }
        return beg;
    }


}
