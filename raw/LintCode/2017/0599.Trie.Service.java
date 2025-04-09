/*

Build tries from a list of pairs. Save top 10 for each node.

Example
Given a list of

<"abc", 2>
<"ac", 4>
<"ab", 9>
Return <a[9,4,2]<b[9,2]<c[2]<>>c[4]<>>>, and denote the following tree structure:

         Root
         / 
       a(9,4,2)
      /    \
    b(9,2) c(4)
   /
 c(2)

 
*/


    public class TrieNode {
        public NavigableMap<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
        public List<Integer> top10 = new ArrayList<Integer>();
    }

    public class TrieService {

        private TrieNode root = new TrieNode();

        public TrieNode getRoot() { return root; }

        public void insert (String word, int frequency) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); ++i) {
                Character c = word.charAt(i);
                if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
                curr = curr.children.get(c);
                addFrequency(curr.top10, frequency);
            }
        }

        public void addFrequency (List<Integer> top10, int frequency) {
                // do an insertion sort
            top10.add(frequency);
            for (int i = top10.size() - 1; i > 0 && less(top10, i-1, i); i--) {
                    swap(top10, i, i-1);
            }
            if (top10.size() > 10) top10.remove(top10.size() - 1);
        }
        
        private boolean less (List<Integer> list, int i, int j) {
                return list.get(i) < list.get(j);
        }
        
        private void swap (List<Integer> list, int i, int j) {
                int tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
        }
     }
