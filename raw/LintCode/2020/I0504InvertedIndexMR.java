package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class InvertedIndex {

    class OutputCollector<K, V> {
        public void collect(K key, V value) {}
    }

    class Document {
        public int id;
        public String content;
    }

    public static class Map {
        public void map(String key, Document value, OutputCollector<String, Integer> output) {

            StringTokenizer st = new StringTokenizer(value.content);
            Set<String> seen = new HashSet<>();

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                int doc = value.id;
                if (seen.contains(word)) continue;
                output.collect(word, doc);
                seen.add(word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values, OutputCollector<String, List<Integer>> output) {
            List<Integer> ans = new ArrayList<>();
            while (values.hasNext()) {
                int curr = values.next();
                ans.add(curr);
            }
            output.collect(key, ans);
        }
    }
}

public class I0504InvertedIndexMR {}
