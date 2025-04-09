package lintcode;

public class I0062SearchRotatedSortedArray {
    
    public int search(int[] A, int target) {
        int beg = findMin(A);
        int a = bsearch(A, 0, beg, target);
        return a != -1 ? a : bsearch(A, beg, A.length, target);
    }

    private int findMin(int[] A) {
        if (A.length <= 1) return 0;
        if (A[0] < A[A.length - 1]) return 0;

        int left = 0;
        int right = A.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[right]) right = mid;
            else left = mid;
        }
        return right;
    }

    private int bsearch(int[] A, int beg, int end, int target) {
        if (beg == end) return -1;
        if (A[beg] > target) return -1;
        while (beg < end - 1) {
            int mid = beg + (end - beg) / 2;
            if (A[mid] > target) end = mid;
            else beg = mid;
        }
        return A[beg] == target ? beg : -1;
    }
}
