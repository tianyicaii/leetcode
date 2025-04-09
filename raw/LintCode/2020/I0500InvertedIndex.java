package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I0500InvertedIndex {
    
    class Document {
        public int id;
        public String content;
    }

    
    Map<String, List<Integer>> ans;
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        ans = new HashMap<>();
        for (Document d : docs) {
            StringBuffer word = new StringBuffer();
            for (int i = 0; i < d.content.length(); i++) {
                char c = d.content.charAt(i);
                if (Character.isWhitespace(c)) {
                    if (word.length() > 0) insert(word.toString(), d.id);
                    word = new StringBuffer();
                } else {
                    word.append(c);
                }
                if (word.length() > 0) insert(word.toString(), d.id);
            }
        }
        return ans;
    }

    void insert(String word, int id) {
        if (!ans.containsKey(word)) ans.put(word, new ArrayList<>());
        List<Integer> list = ans.get(word);
        if (!list.isEmpty() && list.get(list.size() - 1) == id) return;
        else list.add(id);
    }

    
}
