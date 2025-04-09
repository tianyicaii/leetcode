package lintcode;

public class I0462NumOccurrences {
    
    private int ceiling(int[] A, int target) {
        int beg = 0;
        int end = A.length;
        if (A[beg] > target) return beg;
        while (beg < end - 1) {
            int mid = (end - beg) / 2 + beg;
            if (A[mid] <= target) beg = mid;
            else end = mid;
        }
        return (A[beg] == target) ? beg : end;
    }

    public int totalOccurrence(int[] A, int target) {
        if (A.length == 0) return 0;
        int last = ceiling(A, target);
        if (last == A.length || A[last] != target) return 0;
        int first = ceiling(A, target-1);
        if (A[first] == target) return last - first + 1;
        else return last - first;
    }

}
