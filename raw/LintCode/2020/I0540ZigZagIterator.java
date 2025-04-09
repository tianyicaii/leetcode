package lintcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class I0540ZigZagIterator {
    
    public class ZigzagIterator {

        Queue<Iterator<Integer>> q = new LinkedList<>();

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            Iterator<Integer> i1 = v1.iterator();
            Iterator<Integer> i2 = v2.iterator();
            if (i1.hasNext()) q.offer(i1);
            if (i2.hasNext()) q.offer(i2);
        }
    
        public int next() {
            Iterator<Integer> i = q.poll();
            int v = i.next();
            if (i.hasNext()) q.offer(i);
            return v;
        }
    
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
