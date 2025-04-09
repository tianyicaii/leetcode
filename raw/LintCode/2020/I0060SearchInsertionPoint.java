package lintcode;

public class I0060SearchInsertionPoint {

    public int searchInsert(int[] A, int target) {

        if (A.length == 0) return 0;
        if (A[0] >= target) return 0;

        int left = 0;
        int right = A.length;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) right = mid;
            else left = mid;
        }

        return left + 1;
    }
    
}
