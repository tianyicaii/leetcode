package lintcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class I0541ZigZagIterator2 {
    

    public class ZigzagIterator2 {

        Queue<Iterator<Integer>> q = new LinkedList<>();

        public ZigzagIterator2(List<List<Integer>> vecs) {
            for (List<Integer> l : vecs) {
                Iterator<Integer> i = l.iterator();
                if (i.hasNext()) q.offer(i);
            }
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
