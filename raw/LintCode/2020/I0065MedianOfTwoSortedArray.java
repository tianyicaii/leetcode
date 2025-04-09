package lintcode;

public class I0065MedianOfTwoSortedArray {
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        int N = A.length + B.length;
        if (N % 2 == 0) return (findK(A, 0, B, 0, N/2-1) + findK(A, 0, B, 0, N/2)) / 2.0;
        return findK(A, 0, B, 0, N/2);
    }

    private int findK(int[] A, int a, int[] B, int b, int k) {

        if (a == A.length) return B[b + k];
        if (b == B.length) return A[a + k];
        if (k == 0) return Math.min(A[a], B[b]);
        if (k == 1) {
            if (A[a] < B[b]) return findK(A, a+1, B, b, k-1);
            else return findK(A, a, B, b+1, k-1);
        }

        int k2 = k/2;
        int x = Math.min(A.length - 1, a + k2 - 1);
        int y = Math.min(B.length - 1, b + k2 - 1);

        if (A[x] < B[y]) return findK(A, x+1, B, b, k-(x-a+1));
        return findK(A, a, B, y+1, k-(y-b+1));
    }

}
