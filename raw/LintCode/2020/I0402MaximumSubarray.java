package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0402MaximumSubarray {
    
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

    Interval max(Interval a, Interval b) { return a.compareTo(b) < 0 ? b : a; }
    Interval add(Interval a, Interval b) {
        if (a.index > b.index) return add(b, a);
        if (a.index + a.len != b.index) throw new IllegalArgumentException();
        return new Interval(a.index, a.len + b.len, a.sum + b.sum);
    }

    public List<Integer> continuousSubarraySum(int[] A) {
        int N = A.length;
        Interval[] includingEnd = new Interval[N];
        Interval max = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                includingEnd[i] = new Interval(0, 1, A[0]);
                max = includingEnd[i];
            } else {
                Interval self = new Interval(i, 1, A[i]);
                includingEnd[i] = max(self,  add(self, includingEnd[i-1]));
                max = max(max, includingEnd[i]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(max.index);
        ans.add(max.index + max.len - 1);
        return ans;
    }


}
