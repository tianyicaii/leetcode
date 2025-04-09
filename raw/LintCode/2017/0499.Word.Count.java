/*

Using map reduce to count word frequency.
https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3A+WordCount+v1.0

Example
        chunk1: "Google Bye GoodBye Hadoop code"
        chunk2: "lintcode code Bye"
    Get MapReduce result:
        Bye: 2
        GoodBye: 1
        Google: 1
        Hadoop: 1
        code: 2
        lintcode: 1

*/


    public static class WordCount {
        
        class OutputCollector<K, V> {
            public void collect (K key, V value) { ; }
        }

        public static class Map {
            public void map (String _, String input, OutputCollector<String, Integer> output) {
                StringTokenizer tokens = new StringTokenizer(input);
                while (tokens.hasMoreTokens()) {
                    String word = tokens.nextToken();
                    output.collect(word, 1);  // count += 1 for this word
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<Integer> values, OutputCollector<String, Integer> output) {
                int sum = 0;
                while (values.hasNext()) {
                        sum += values.next();
                }
                output.collect(key, sum);
            }
        }
        
        
    }
