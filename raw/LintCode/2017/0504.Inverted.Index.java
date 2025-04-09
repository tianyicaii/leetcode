/*

Use map reduce to build inverted index for given documents.

*/


    public static class InvertedIndex {
        
        class OutputCollector<K, V> {
            public void collect (K key, V value) { ; }
        }
        
        class Document {
            public int id;
            public String content;
        }
        
        public static class Map {
            public void map (String docID, Document value, OutputCollector<String, Integer> output) {
                StringTokenizer words = new StringTokenizer(value.content);
                while (words.hasMoreTokens()) {
                    String word = words.nextToken();
                    output.collect(word, value.id);
                }
            }
        }

        public static class Reduce {
            
                // assume for each word, its docID stream is sorted
            public void reduce (String key, Iterator<Integer> values, OutputCollector<String, List<Integer>> output) {
                List<Integer> ans = new ArrayList<Integer>();
                Integer prev = null;
                while (values.hasNext()) {
                    int curr = values.next();  // skip duplicates doc IDs
                    if(prev == null || prev != curr) {
                        ans.add(curr);
                    }
                    prev = curr;
                }
                output.collect(key, ans);
            }
        }
    }   
