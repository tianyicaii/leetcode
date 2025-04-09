// https://leetcode.com/problems/maximum-product-of-word-lengths/


public class Solution {


	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) return 0;
		int n = words.length;
		int[] masks = new int[n];

		for (int i = 0; i < n; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				masks[i] |= (1 << (word.charAt(j) - 'a'));
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((masks[i] & masks[j]) == 0)
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}	


}

