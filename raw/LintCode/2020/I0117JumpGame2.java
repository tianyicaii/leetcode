package lintcode;

import java.util.Arrays;

public class I0117JumpGame2 {
    
    public int jump(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        Arrays.fill(B, Integer.MAX_VALUE);
        B[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= A[i] && i + j < N; j++) {
                B[i + j] = Math.min(B[i + j], B[i] + 1);
            }
        }
        return B[N-1];
    }
}
