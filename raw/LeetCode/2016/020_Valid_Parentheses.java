// https://leetcode.com/problems/valid-parentheses/


public class Solution {

		
	public boolean isValid (String s) {
		Deque<Character> LEFT = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') LEFT.offerLast(c);
			else {  // closing ones
				if (LEFT.isEmpty()) return false;  // check before poll
				char b = LEFT.pollLast();
				if (b == '(' && c == ')' ||
					b == '[' && c == ']' ||
					b == '{' && c == '}') continue;  // match, go on
				else return false;
			}
		}
		return LEFT.isEmpty();
	}


}

