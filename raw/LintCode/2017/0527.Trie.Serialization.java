/*

Serialize and deserialize a trie (prefix tree, search on internet for more details).
You can specify your own serialization algorithm, the online judge only cares about whether you can successfully deserialize the output from your own serialize function.

Notice: You don't have to serialize like the test data, you can design your own format.

Example
    str = serialize(old_trie)
    >> str can be anything to represent a trie
    new_trie = deserialize(str)
    >> new_trie should have the same structure and values with old_trie
    An example of test data: trie tree <a<b<e<>>c<>d<f<>>>>, denote the following structure:

         root
          /
         a
       / | \
      b  c  d
     /       \
    e         f

*/


    public class TrieNode {
        public NavigableMap<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
    }


    public String serialize (TrieNode root) {
        if (root == null) return "";
        if (root.children.isEmpty()) return "<>";  // root is special in the sense that its children is not preceded by a letter
        
        Stack<Iterator<Map.Entry<Character, TrieNode>>> s = new Stack<>();
        s.push(root.children.entrySet().iterator());
        StringBuffer ans = new StringBuffer();
        
        while (!s.isEmpty()) {
                Iterator<Map.Entry<Character, TrieNode>> curr = s.pop();
                if (curr.hasNext()) {
                    Map.Entry<Character, TrieNode> e = curr.next();
                    ans.append(e.getKey());
                    ans.append('<');
                    s.push(curr);
                    s.push(e.getValue().children.entrySet().iterator());
                } else {
                    ans.append('>');  // root's iterator generates one more '>'
                }
        }
        
        return ans.toString();
    }

    public TrieNode deserialize (String data) {
        if (data == null || data.length() == 0) return null;
        if (data.equals("<>")) return new TrieNode();

        TrieNode curr = new TrieNode();
        Stack<TrieNode> s = new Stack<TrieNode>();
        
        for (Character c : data.toCharArray()) {
                if (c == '<') {  // ignored

                } else if (c == '>') {
                    if (!s.isEmpty())
                        curr = s.pop();
                } else {  // a letter (not open parenthesis) starts a new node
                    curr.children.put(c, new TrieNode());
                    s.push(curr);
                    curr = curr.children.get(c);
                }
        }
            return curr;
     }
