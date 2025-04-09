package lintcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class I0473Dictionary {
    


    public class WordDictionary {

        class TrieNode {
            Map<Character, TrieNode> links = new HashMap<>();
            boolean isWord = false;
        }

        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
                curr = curr.links.get(c);
            }
            curr.isWord = true;
        }
    
        public boolean search(String word) {

            Queue<TrieNode> q = new LinkedList<>();
            q.add(root);

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int N = q.size();
                for (int j = 0; j < N; j++) {
                    TrieNode x = q.poll();
                    if (c == '.') {
                        for (Map.Entry<Character, TrieNode> e : x.links.entrySet()) q.offer(e.getValue());
                    } else if (x.links.containsKey(c)) {
                        q.offer(x.links.get(c));
                    }
                }
            }
            for (TrieNode x : q) if (x.isWord) return true;
            return false;
        }
    }

}
