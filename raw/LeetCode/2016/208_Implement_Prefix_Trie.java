// https://leetcode.com/problems/implement-trie-prefix-tree/


public class Solution {


	public class Trie {

		private class TrieNode {  // each TrieNode is a bar, each link is a transition
			HashMap<Character, TrieNode> links;
			boolean isWord;
			public TrieNode () {
				links = new HashMap<>();
			}
		}
		
		TrieNode root;
		
	    public Trie() {
	    	root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	TrieNode curr = root;
	    	for (int i = 0; i < word.length(); i++) {
	    		if (!curr.links.containsKey(word.charAt(i)))
	    			curr.links.put(word.charAt(i), new TrieNode());
	    		curr = curr.links.get(word.charAt(i));
	    	}
	    	curr.isWord = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	TrieNode curr = root;
	    	for (int i = 0; i < word.length(); i++) {
	    		if (!curr.links.containsKey(word.charAt(i))) return false;
	    		curr = curr.links.get(word.charAt(i));
	    	}
	    	return curr.isWord;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode curr = root;
	    	for (int i = 0; i < prefix.length(); i++) {
	    		if (!curr.links.containsKey(prefix.charAt(i))) return false;
	    		curr = curr.links.get(prefix.charAt(i));
	    	}
	    	return true;
	    }  
	}


}

