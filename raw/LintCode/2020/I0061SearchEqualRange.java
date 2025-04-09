package lintcode;

public class I0061SearchEqualRange {
    
    public int[] searchRange(int[] A, int target) {

        int left = floor(A, target);
        int right = ceiling(A, target);

        if (left == -1 || left == A.length || A[left] != target) return new int[] {-1, -1};;
        return new int[] {left, right - 1};
    }

    private int floor(int[] A, int target) {

        if (A.length == 0) return -1;
        if (A[0] > target) return -1;
        if (A[0] == target) return 0;

        int left = 0;
        int right = A.length;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= target) right = mid;
            else left = mid;
        }

        return left + 1;
    }

    private int ceiling(int[] A, int target) {

        if (A.length == 0) return -1;
        if (A[0] > target) return 0;

        int left = 0;
        int right = A.length;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) left = mid;
            else right = mid;
        }

        return right;
    }

}
