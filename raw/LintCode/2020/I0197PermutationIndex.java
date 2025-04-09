package lintcode;

public class I0197PermutationIndex {
    
    private long fact(long n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
    
    public long permutationIndex(int[] A) {


        int N = A.length;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (A[j] < A[i]) {
                    cnt += fact(N - i - 1);
                }
            }
        }

        return cnt+1;
    }
}
