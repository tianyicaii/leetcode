// https://leetcode.com/problems/evaluate-reverse-polish-notation/


public class Solution {
	

	public int evalRPN (String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String s : tokens) {
			if      (s.equals("+")) {
				int b = stack.pollLast();
				int a = stack.pollLast();
				stack.offerLast(a + b);
			}
			else if (s.equals("-")) {
				int b = stack.pollLast();
				int a = stack.pollLast();
				stack.offerLast(a - b);
				
			}
			else if (s.equals("*")) {
				int b = stack.pollLast();
				int a = stack.pollLast();
				stack.offerLast(a * b);
				
			}
			else if (s.equals("/")) {
				int b = stack.pollLast();
				int a = stack.pollLast();
				stack.offerLast(a / b);
				// divide by zero potential
			}
			else {
				stack.offerLast(Integer.parseInt(s));
			}	
		}
		return stack.pollLast();
	}	


}

