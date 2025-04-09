// https://leetcode.com/problems/basic-calculator/


public class Solution {


	public int calculate (String s) {
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		int sgn = 1;	
		int acc = 0;
		int num = 0;
		
		int i = 0;
		while (i < s.length()) {
			
			char c = s.charAt(i);
			
			if (Character.isWhitespace(c)) {  // done scanning current number or operator or parenthesis
				acc += sgn * num;
				num = 0;
			}
			else if (Character.isDigit(c)) {  // still scanning current number
				num = num * 10 + (c - '0');
			}
			else if (c == '+') {  // same function as space, plus sign
				acc += sgn * num;
				num = 0;
				sgn = 1;
			}
			else if (c == '-') {  // same function as space, minus sign
				acc += sgn * num;
				num = 0;
				sgn = -1;
			}
			else if (c == '(') {  // go to a new level, store current level
				stack.offerLast(acc);
				stack.offerLast(sgn);
				acc = 0;
				sgn = 1;
			}
			else {  // c == ')'
				acc += sgn * num;		  // finish this level
				num = 0;
				acc *= stack.pollLast();  // get sign
				acc += stack.pollLast();  // resume previous level
			}
			i++;
		}
		
		acc += sgn * num;
		
		return acc;
	}


}

