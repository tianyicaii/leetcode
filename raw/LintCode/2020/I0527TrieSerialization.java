package lintcode;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;

public class I0527TrieSerialization {

    public class TrieNode {
        public NavigableMap<Character, TrieNode> children;
        public TrieNode() { children = new TreeMap<Character, TrieNode>(); }
    }

    public String serialize(TrieNode root) {
        if (root == null) return "";
        StringBuilder str = new StringBuilder();
        Stack<Iterator<Map.Entry<Character, TrieNode>>> stack = new Stack<>();
        str.append('<');
        stack.push(root.children.entrySet().iterator());
        while (!stack.isEmpty()) {
            Iterator<Map.Entry<Character, TrieNode>> curr = stack.pop();
            if (curr.hasNext()) {
                Map.Entry<Character, TrieNode> e = curr.next();
                str.append(e.getKey());
                str.append('<');
                stack.push(curr);
                stack.push(e.getValue().children.entrySet().iterator());
            } else {
                str.append('>');
            }
        }
        return str.toString();
    }

    public TrieNode deserialize(String data) {
        if (data.equals("")) return null;
        TrieNode root = new TrieNode();
        if (data.equals("<>")) return root;
        char[] input = data.substring(1, data.length()-1).toCharArray();
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);

        for (char c : input) {
            if (c == '<') {
                ;
            } else if (c == '>') {
                stack.pop();
            } else {
                TrieNode x = new TrieNode();
                stack.peek().children.put(c, x);
                stack.push(x);
            }
        }
        return stack.pop();
    }

}
