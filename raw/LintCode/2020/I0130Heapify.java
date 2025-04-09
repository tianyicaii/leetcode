package lintcode;

public class I0130Heapify {

    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            sink(A, i);
        }
    }

    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    private void sink(int[] A, int a) {
        int N = A.length;
        while (true) {
            int l = a * 2 + 1;
            int r = a * 2 + 2;
            if (l >= N) break;
            int x = a;
            if (A[x] > A[l]) x = l;
            if (r < N && A[x] > A[r]) x = r;
            if (x == a) break;
            swap(A, a, x);
            a = x; 
        }
    }
}
