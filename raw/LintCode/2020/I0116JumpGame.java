package lintcode;

public class I0116JumpGame {
    
    public boolean canJump(int[] A) {
        int N = A.length;
        boolean[] B = new boolean[N];
        B[0] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= A[i] && i + j < N; j++) {
                B[i + j] = B[i];
            }
        }
        return B[N-1];
    }

    public boolean canJump_(int[] A) {
        int N = A.length;
        boolean[] B = new boolean[N];
        B[N-1] = true;
        for (int i = N-2; i >= 0; i--) {
            for (int j = 1; j <= A[i] && i + j < N && !B[i]; j++) {
                B[i] = B[i + j];
            }
        }
        return B[0];
    }
    
}
