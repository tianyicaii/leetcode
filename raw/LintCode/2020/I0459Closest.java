package lintcode;

public class I0459Closest {
    
    public int closestNumber(int[] A, int target) {
        if (A.length == 0) return -1;
        int beg = 0;
        int end = A.length;

        while (beg < end - 1) {
            int mid = beg + (end - beg) / 2;
            if (A[mid] <= target) beg = mid;
            else end = mid; 
        }

        if (end == A.length) return beg;
        return (Math.abs(target - A[beg]) <= Math.abs(target - A[end])) ? beg : end;
    }
}
