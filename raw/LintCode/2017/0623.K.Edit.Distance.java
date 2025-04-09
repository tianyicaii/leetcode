/*
 *  http://www.lintcode.com/en/problem/k-edit-distance/
 *
 *  Given a set of strings which just has lower case letters and a target string, output all the strings for each the edit distance with the target no greater than k.
 *  You have the following 3 operations permitted on a word:
 *      Insert a character
 *      Delete a character
 *      Replace a character
 */


	private class TrieNode {
		Map<Character, TrieNode> links = new HashMap<>();
		boolean eof = false;
	}
	
	TrieNode root;
	List<String> ans;
	String target;
	int k;
	
	void add (String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (!curr.links.containsKey(word.charAt(i))) curr.links.put(word.charAt(i), new TrieNode());
			curr = curr.links.get(word.charAt(i));
		}
		curr.eof = true;
	}
	
	public List<String> kDistance (String[] words, String target, int k) {
		root = new TrieNode();
		ans = new ArrayList<>();
		this.target = target;
		this.k = k;
		
		for (String w : words) add(w);
		int[] m = new int[target.length() + 1];
		dp(root, new StringBuilder(), m);  // start with empty string (ending at root)
		return ans;
	}
	



	public void dp (TrieNode curr, StringBuilder path, int[] prevRow) {
		
		int[] currRow = new int[target.length() + 1];
		for (int j = 0; j <= target.length(); j++) {  // run dp with substr ending at this node
			if (path.length() == 0) currRow[j] = j;
			else if (j == 0) currRow[j] = path.length();
			else {
				if (path.charAt(path.length() - 1) == target.charAt(j - 1)) currRow[j] = prevRow[j - 1];
				else currRow[j] = Math.min(Math.min(currRow[j - 1], prevRow[j]), prevRow[j - 1]) + 1;
			}
		}
		if (currRow[target.length()] <= k && curr.eof) ans.add(path.toString());  // if any word falls in k, add to ans

		
		for (Map.Entry<Character, TrieNode> e : curr.links.entrySet()) {  // for each possibility, run dp for that row 
			path.append(e.getKey());
			dp(e.getValue(), path, currRow);
			path.delete(path.length() - 1, path.length());
		}
	}
