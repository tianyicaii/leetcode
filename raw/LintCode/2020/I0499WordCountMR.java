package lintcode;

import java.util.Iterator;
import java.util.StringTokenizer;

class OutputCollector<K, V> {
    public void collect(K key, V value) {}
}

class WordCount {

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            StringTokenizer t = new StringTokenizer(value);
            while (t.hasMoreTokens()) output.collect(t.nextToken(), 1);
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values, OutputCollector<String, Integer> output) {
            int sum = 0;
            while (values.hasNext()) sum += values.next();
            output.collect(key, sum);
        }
    }
}

public class I0499WordCountMR {
    
}
