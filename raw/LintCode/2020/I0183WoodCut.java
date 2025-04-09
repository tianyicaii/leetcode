package lintcode;

public class I0183WoodCut {


    public int woodCut(int[] L, int k) {

        if (k > sum(L)) return 0;
        int left = 1;
        int right = max(L);
        if (isViable(L, k, right)) return right;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isViable(L, k, mid)) left = mid;
            else right = mid;
        }
        return left;
    }
    
    private boolean isViable(int[] L, int k, int l) {
        int cnt = 0;
        for (int i : L) cnt += i / l;
        return cnt >= k;
    }

    private int max(int[] L) {
        int max = 0;
        for (int i : L) max = Math.max(max, i);
        return max;
    }

    private int sum(int[] L) {
        long sum = 0;
        for (int i : L) sum += i;
        return (int)Math.min(sum, Integer.MAX_VALUE); 
    }
}
