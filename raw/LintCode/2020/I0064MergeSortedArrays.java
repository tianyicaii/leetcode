package lintcode;

public class I0064MergeSortedArrays {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {

        int a = m - 1;
        int b = n - 1;
        int c = m + n - 1;

        while (c >= 0) {
            if (a < 0) A[c--] = B[b--];
            else if (b < 0) A[c--] = A[a--];
            else if (A[a] > B[b]) A[c--] = A[a--];
            else A[c--] = B[b--];
        }
    }
    
}
