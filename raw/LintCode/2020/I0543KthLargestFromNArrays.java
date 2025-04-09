package lintcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class I0543KthLargestFromNArrays {
    
    class Stream implements Comparable<Stream> {
        int[] a;
        int index;
        Stream(int[] a) { this.a = a; Arrays.sort(a); index = a.length-1; }
        boolean hasNext() { return index >= 0; }
        int next() { return a[index--]; }
        int peek() { return a[index]; }
        public int compareTo(Stream other) {
            if (this.peek() < other.peek()) return 1;
            if (this.peek() > other.peek()) return -1;
            return 0;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {
        PriorityQueue<Stream> pq = new PriorityQueue<>();
        for (int[] a : arrays) {
            Stream s = new Stream(a);
            if (s.hasNext()) pq.offer(s);
        }
        for (int i = 0; i < k-1; i++) {
            if (pq.isEmpty()) return -1;
            Stream s = pq.poll();
            s.next();
            if (s.hasNext()) pq.offer(s);
        }
        return pq.peek().next();
    }
}
