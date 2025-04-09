// https://leetcode.com/problems/shortest-word-distance-iii/


public class Solution {


	public int shortestWordDistance (String[] words, String word1, String word2) {
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while (i < words.length && !words[i].equals(word1)) i++;
		while (j < words.length && !words[j].equals(word2)) j++;
		while (i < words.length && j < words.length) {
			if (i != j)
				min = Math.min(min, Math.abs(j - i));
			if (i < j) { i++; while (i < words.length && !words[i].equals(word1)) i++; }
			else       { j++; while (j < words.length && !words[j].equals(word2)) j++; }
		}
		return min;
	}


}

