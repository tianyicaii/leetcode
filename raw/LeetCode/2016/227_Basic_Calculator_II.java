// https://leetcode.com/problems/basic-calculator-ii/


public class Solution {


	int i;
	String s;
	
	public int calculate(String s) {
		
		this.s = s;
		this.i = 0;

		Deque<Integer> stack = new ArrayDeque<>();  // first * /, then + -
		int sign = 1;
		skipWhitespaces();
		int x    = readInteger();
		skipWhitespaces();

		
		while (i < s.length()) {
									
			char operator = s.charAt(i++);
			
			skipWhitespaces();
			int y = readInteger();
			skipWhitespaces();
			
			if (operator == '+') {
				stack.offerLast(sign);
				stack.offerLast(x);				
				sign = 1;
				x = y;
			}
			else if (operator == '-') {
				stack.offerLast(sign);
				stack.offerLast(x);				
				sign = -1;
				x = y;
				
			}
			else if (operator == '*') {
				x = x * y;
			}
			else {  // /
				x = x / y;  // assume y is not zero
			}
		}		
		stack.offerLast(sign);
		stack.offerLast(x);	
		
		int ans = 0;
		while (!stack.isEmpty()) {
			int sgn = stack.pollFirst();
			int num = stack.pollFirst();
			ans += sgn * num;  // left to right
		}
		return ans;
	}
	
	private void skipWhitespaces () {
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++;
	}
	
	private int readInteger () {
		int ans = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!Character.isDigit(c)) break;
			ans = ans * 10 + (c - '0');
			i++;
		}
		return ans;
	}


}

