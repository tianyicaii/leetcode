package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0403MaximumSubarrayWrap {

    class Interval implements Comparable<Interval> {
        final int index;
        final int len;
        final int sum;
        Interval(int i, int l, int s) { index = i; len = l; sum = s; }

        @Override
        public int compareTo(Interval other) {
            if (this.sum < other.sum) return -1;
            if (this.sum > other.sum) return 1;
            if (this.index > other.index) return -1;
            if (this.index < other.index) return 1;
            if (this.len > other.len) return -1;
            if (this.len < other.len) return 1;
            return 0;
        }
    }
    Interval min(Interval a, Interval b) { return a.compareTo(b) < 0 ? a : b; }
    Interval max(Interval a, Interval b) { return a.compareTo(b) < 0 ? b : a; }
    Interval add(Interval a, Interval b) {
        if (a.index > b.index) return add(b, a);
        if (a.index + a.len != b.index) throw new IllegalArgumentException();
        return new Interval(a.index, a.len + b.len, a.sum + b.sum);
    }

    public List<Integer> continuousSubarraySumII(int[] A) {

        int N = A.length;
        int total = 0;
        for (int i : A) total += i;

        Interval max = find(A, true);
        Interval min = find(A, false);

        if (min.len == N) ;
        else if (max.sum >= total - min.sum) ;
        else max = new Interval((min.index + min.len) % N, N - min.len, total - min.sum);

        List<Integer> ans = new ArrayList<>();
        ans.add(max.index);
        ans.add((max.index + max.len - 1)%N);
        return ans;
    }

    private Interval find(int[] A, boolean isMax) {
        int N = A.length;
        Interval[] includingEnd = new Interval[N];
        Interval m = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                includingEnd[i] = new Interval(0, 1, A[0]);
                m = includingEnd[i];
            } else {
                Interval self = new Interval(i, 1, A[i]);
                if (isMax) {
                    includingEnd[i] = max(self,  add(self, includingEnd[i-1]));
                    m = max(m, includingEnd[i]);    
                } else {
                    includingEnd[i] = min(self,  add(self, includingEnd[i-1]));
                    m = min(m, includingEnd[i]);    
                }
            }
        }
        return m;
    }

}
