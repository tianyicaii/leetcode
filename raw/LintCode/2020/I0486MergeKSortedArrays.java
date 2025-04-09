package lintcode;

import java.util.PriorityQueue;

public class I0486MergeKSortedArrays {

    public int[] mergekSortedArrays(int[][] arrays) {
        int N = 0;
        PriorityQueue<Iter> pq = new PriorityQueue<>();
        for (int[] a : arrays) {
            N += a.length;
            Iter it = new Iter(a);
            if (it.hasNext()) pq.offer(it);
        }

        int[] ans = new int[N];
        int i = 0;
        while (!pq.isEmpty()) {
            Iter it = pq.poll();
            ans[i++] = it.next();
            if (it.hasNext()) pq.offer(it);
        }
        return ans;
    }


    class Iter implements Comparable<Iter> {
        int[] A;
        int i = 0;
        Iter(int[] A) { this.A = A; }
        boolean hasNext() { return i < A.length; }
        int next() { return A[i++]; }
        int peek() { return A[i]; }
        public int compareTo(Iter other) {
            if (this.peek() < other.peek()) return -1;
            if (this.peek() == other.peek()) return 0;
            return 1;
        }
    }
}
