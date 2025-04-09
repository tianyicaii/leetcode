/*

Use Map Reduce to find anagrams in a given list of words.
Example
    Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"],["code"].
    Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba"], ["cd", "dc"], ["e"].

*/

    public static class Anagram {

        class OutputCollector<K, V> {
            public void collect (K key, V value) { ; }
        }
        
        class Document {
            public int id;
            public String content;
        }
        
        public static class Map {
            
                private String getReps (String word) {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    // return Arrays.toString(chars);  // XXX: what is the difference?
                    return new String(chars);
                }
            
                // map group ID to each word
            public void map (String key, String value, OutputCollector<String, String> output) {
                StringTokenizer words = new StringTokenizer(value);
                while (words.hasMoreTokens()) {
                    String word = words.nextToken();
                    String reps = getReps(word);
                    output.collect(reps, word);  // add one group member.
                }
            }
        }

        public static class Reduce {
            public void reduce (String key, Iterator<String> values, OutputCollector<String, List<String>> output) {
                List<String> ans = new ArrayList<String>();
                while (values.hasNext()) {  // assume no duplicates in words
                        ans.add(values.next());
                }
                output.collect(key, ans);
            }
        }
    }
