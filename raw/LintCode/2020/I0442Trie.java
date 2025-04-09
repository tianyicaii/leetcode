package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0442Trie {


    public class Trie {

        class TrieNode {
            Map<Character, TrieNode> links = new HashMap<>();
            boolean isWord = false;
        }

        TrieNode root = new TrieNode();

        public Trie() {}
    
        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
                curr = curr.links.get(c);
            }
            curr.isWord = true;
        }
    
        public boolean search(String word) {
            TrieNode x = seek(word);
            return x != null && x.isWord;
        }
    
        public boolean startsWith(String prefix) { return seek(prefix) != null; }

        private TrieNode seek(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!curr.links.containsKey(c)) return null;
                curr = curr.links.get(c);
            }
            return curr;
        }
    }

}
