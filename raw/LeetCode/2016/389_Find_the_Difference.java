// https://leetcode.com/problems/find-the-difference/


public class Solution {


	public char findTheDifference (String s, String t) {
		char XOR = (char) 0;
		for (int i = 0; i < s.length(); i++) {
			XOR ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			XOR ^= t.charAt(i);
		}
		return XOR;
	}

}

