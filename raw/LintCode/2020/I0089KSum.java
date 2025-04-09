package lintcode;

import java.util.HashMap;

public class I0089KSum {

    HashMap<String, Integer> m;
    int[] a;

    public int kSum(int[] A, int k, int target) {
        m = new HashMap<>();
        a = A;
        return kSum(A.length, k, target);
    }

    public String getKey(int end, int k, int target) {
        return "" + end + "," + k + "," + target;
    }

    public int kSum(int end, int k, int target) {
        if (target < 0) return 0;
        if (k == 0 && target == 0) return 1;
        if (k == 0 && target > 0) return 0;
        if (end < k) return 0;
        String key = getKey(end, k, target);
        if (m.containsKey(key)) return m.get(key);

        int n = kSum(end-1, k, target) + kSum(end-1, k-1, target - a[end-1]);
        m.put(key, n);
        return n;
    }

}
