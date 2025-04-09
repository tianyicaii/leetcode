package lintcode;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class TopKFrequentWords {

    class OutputCollector<K, V> {
        public void collect(K key, V value) {}
    }

    class Document {
        public int id;
        public String content;
    }

    public static class Map {
        public void map(String k, Document value, OutputCollector<String, Integer> output) {
            StringTokenizer st = new StringTokenizer(value.content);
            while (st.hasMoreTokens()) {
                output.collect(st.nextToken(), 1);
            }
        }
    }

    public static class Reduce {

        class Count implements Comparable<Count> {
            String str;
            int count;
            Count(String str, int count) { this.str = str; this.count = count; }
            public int compareTo(Count other) {
                if (this.count < other.count) return -1;
                if (this.count > other.count) return 1;
                return -this.str.compareTo(other.str);
            }
        }

        PriorityQueue<Count> pq = new PriorityQueue<>();
        int k;

        public void setup(int k) { this.k = k; }

        public void reduce(String key, Iterator<Integer> values) {
            int count = 0;
            while (values.hasNext()) {
                values.next();
                count ++;
            }
            pq.offer(new Count(key, count));
            if (pq.size() > k) pq.poll();
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            Stack<Count> ans = new Stack<>();
            while (!pq.isEmpty()) ans.push(pq.poll());
            while (!ans.isEmpty()) {
                Count c = ans.pop();
                output.collect(c.str, c.count);
            }
        }
    }
}

public class I0459TopKWordsMR {}
