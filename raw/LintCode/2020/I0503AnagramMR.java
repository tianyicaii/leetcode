package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class Anagram {

    class OutputCollector<K, V> {
        public void collect(K key, V value) {}
    }

    public static class Map {

        private String getReduceKey(String value) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        public void map(String key, String value, OutputCollector<String, String> output) {
            StringTokenizer st = new StringTokenizer(value);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                String reduceKey = getReduceKey(word);
                output.collect(reduceKey, word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values, OutputCollector<String, List<String>> output) {
            List<String> ans = new ArrayList<>();
            while (values.hasNext()){
                ans.add(values.next());
            }
            output.collect(key, ans);
        }
    }
}

public class I0503AnagramMR {}
