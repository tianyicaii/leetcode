/*
 *  http://www.lintcode.com/en/problem/implement-trie/
 *
 *  Implement a trie with insert, search, and startsWith methods.
 */


	public class Trie {
		
		private class TrieNode {  // each node represent the point between two letters
		    Map<Character, TrieNode> links;
		    boolean eof;
		    public TrieNode () {
		        links = new HashMap<>();
		        eof = false;
		    }
		}
		
	    private TrieNode root;

	    public Trie () {
	    		root = new TrieNode();
	    }

	    public void insert (String word) {
	    		TrieNode curr = root;
	    		for (int i = 0; i < word.length(); i++) {
	    			char c = word.charAt(i);
	    			if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
	    			curr = curr.links.get(c);
	    		}
	    		curr.eof = true;
	    }
	    
	    private TrieNode find (String s) {
	    		TrieNode curr = root;
	    		for (int i = 0; i < s.length(); i++) {
	    			char c = s.charAt(i);
	    			if (!curr.links.containsKey(c)) return null;
	    			curr = curr.links.get(c);
	    		}
	    		return curr;
	    }

	    public boolean search (String word) {  //  duplicate code, need re factor
	    		TrieNode x = find(word);
	    		return x != null && x.eof;
	    }

	    public boolean startsWith (String prefix) {
	    		return find(prefix) != null;
	    }
	}	
