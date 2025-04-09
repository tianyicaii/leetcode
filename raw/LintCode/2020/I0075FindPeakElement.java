package lintcode;


public class I0075FindPeakElement {
    public int findPeak(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right - 1) {
            int mid = (right - left) / 2 + left;
            if (A[mid] < A[mid - 1]) right = mid;
            else if (A[mid] < A[mid + 1]) left = mid;
            else return mid;
        }
        throw new IllegalArgumentException();
    }
}
