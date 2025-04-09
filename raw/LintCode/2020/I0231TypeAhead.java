package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class I0231TypeAhead {
    

    public class Typeahead {

        private class TrieNode {
            Map<Character, TrieNode> links = new HashMap<>();
            Set<String> words = new HashSet<>();
        }
    
        TrieNode root = new TrieNode();
    
        private void insert(String substr, String word) {
            TrieNode curr = root;
            for (int i = 0; i < substr.length(); i++) {
                char c = substr.charAt(i);
                if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
                curr = curr.links.get(c);
            }
            curr.words.add(word);
        }

        private List<String> get(String substr) {
            TrieNode curr = root;
            for (int i = 0; i < substr.length(); i++) {
                char c = substr.charAt(i);
                if (!curr.links.containsKey(c)) return new ArrayList<>();
                curr = curr.links.get(c);
            }
            return new ArrayList<>(curr.words);
        }
    
        public Typeahead(Set<String> dict) {
            for (String s : dict) {
                for (int i = 0; i < s.length(); i++) {
                    for (int j = i + 1; j <= s.length(); j++) {
                        insert(s.substring(i, j), s);
                    }
                }
            }
        }
    

        public List<String> search(String str) {
            return get(str);
        }
    }

}
