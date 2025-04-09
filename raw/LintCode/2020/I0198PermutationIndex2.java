package lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class I0198PermutationIndex2 {

    private long fact(long n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    private long count(int[] A, int i, Map<Integer, Integer> numEqual) {
        long d = fact(A.length - i - 1);
        long n = 1;
        for (Map.Entry<Integer, Integer> e : numEqual.entrySet()) {
            n *= fact(e.getValue());
        }
        return d / n;
    }

    public long permutationIndexII(int[] A) {
        int N = A.length;

        Map<Integer, Integer> numEqual = new HashMap<>();
        for (int i : A) {
            if (!numEqual.containsKey(i)) numEqual.put(i, 0);
            numEqual.put(i, numEqual.get(i) + 1);
        }

        long cnt = 1;
        for (int i = 0; i < N; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i+1; j < N; j++) {
                if (A[j] < A[i] && !seen.contains(A[j])) {
                    numEqual.put(A[j], numEqual.get(A[j]) - 1);
                    cnt += count(A, i, numEqual);
                    numEqual.put(A[j], numEqual.get(A[j]) + 1);
                    seen.add(A[j]);
                }
            }
            numEqual.put(A[i], numEqual.get(A[i]) - 1);
        }

        return cnt;
    }
}
