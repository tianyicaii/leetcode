/*

Find top k frequent words with map reduce framework.
  - The mapper's key is the document id, value is the content of the document, words in a document are split by spaces.
  - For reducer, the output should be at most k key-value pairs, which are the top k words and their frequencies in this reducer.
    The judge will take care about how to merge different reducers' results to get the global top k frequent words,
    so you don't need to care about that part.
  - The k is given in the constructor of TopK class.

Notice: For the words with same frequency, rank them with alphabet.

Example
    Given document A =
        lintcode is the best online judge
        I love lintcode
    and document B =
        lintcode is an online judge for coding interview
        you can test your code online at lintcode
    The top 2 words and their frequencies should be
        lintcode, 4
        online, 3

*/


    public static class TopKFrequentWords {
        
        
        class OutputCollector<K, V> {
            public void collect (K key, V value) { ; }
        }
        
        class Document {
            public int id;
            public String content;
        }

        
        public static class Map {
            public void map (String docID, Document value, OutputCollector<String, Integer> output) {
                String[] words = value.content.split("\\s+");
                for (String w : words) {
                        output.collect(w, 1);
                }
            }
        }


        public static class Reduce {
                
                class Count implements Comparable<Count> {  // pair each word with its frequency
                    String word;
                    int count;
                    public Count (String w, int c) { word = w; count = c; }
                    public int compareTo (Count other) {  // for min heap
                        if (count == other.count) return - word.compareTo(other.word);
                        else return this.count - other.count;
                    }
                }
            
            private PriorityQueue<Count> pq = new PriorityQueue<>();  // min heap
            private int k;
            public void setup (int k) { this.k = k; }   

            public void reduce (String key, Iterator<Integer> values) {  // assume each invocation has different key
                int sum = 0;
                while (values.hasNext()) {
                        sum += values.next();
                }
                Count c = new Count(key, sum);
                pq.offer(c);
                if (pq.size() > k) pq.poll();
            }
            
            public void cleanup (OutputCollector<String, Integer> output) {  // return top k frequent
                List<Count> topK = new ArrayList<Count>();  // need a buffer to get reverse order
                while (!pq.isEmpty())
                        topK.add(pq.poll());
                Collections.reverse(topK);
                for (Count c : topK)
                        output.collect(c.word, c.count);
            }
        }
        
        
    }   
