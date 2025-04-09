/*
 *  http://www.lintcode.com/en/problem/expression-evaluation/
 *
 *  Given an expression string array, return the final result of this expression
 */

	public int evaluateExpression (String[] expression) {
		

		Stack<Deque<String>> expr = new Stack<>();
		Deque<String> curr = new ArrayDeque<>();
		
		for (String e : expression) {
			
			
			if (Character.isDigit(e.charAt(0))) {
				
				if (curr.isEmpty()) curr.offerLast(e);
				else if (curr.peekLast().equals("+") || curr.peekLast().equals("-")) curr.offerLast(e);
				else {  // evaluate * and /
					String op = curr.pollLast();
					int left = Integer.parseInt(curr.pollLast());
					int right = Integer.parseInt(e);
					if (op.equals("*")) curr.offerLast(left * right + "");
					else curr.offerLast(left / right + "");
				}
			}
			
			
			else if (e.equals("+") || e.equals("-")) curr.offerLast(e);
			else if (e.equals("*") || e.equals("/")) curr.offerLast(e);
			
			
			
			else if (e.equals("(")) {  // first process parentheses
				expr.push(curr);
				curr = new ArrayDeque<>();
			}
			
			else {  // ")"
				if (curr.isEmpty()) {
					curr = expr.pop();
					continue;
				}
				while (curr.size() != 1) {  // evaluate + and -
					int left = Integer.parseInt(curr.pollFirst());
					String op = curr.pollFirst();
					int right = Integer.parseInt(curr.pollFirst());
					if (op.equals("+")) curr.offerFirst(left + right + "");
					else curr.offerFirst(left - right + "");
				}
				
				String sub = curr.pollFirst();
				curr = expr.pop();
				if (curr.isEmpty()) curr.offerLast(sub);
				else if (curr.peekLast().equals("+") || curr.peekLast().equals("-")) curr.offerLast(sub);
				else {
					String op = curr.pollLast();
					int left = Integer.parseInt(curr.pollLast());
					int right = Integer.parseInt(sub);
					if (op.equals("*")) curr.offerLast(left * right + "");
					else curr.offerLast(left / right + "");
				}
			}
		}
		
		if (curr.isEmpty()) return 0;
		
		while (curr.size() != 1) {
			int left = Integer.parseInt(curr.pollFirst());
			String op = curr.pollFirst();
			int right = Integer.parseInt(curr.pollFirst());
			if (op.equals("+")) curr.offerFirst(left + right + "");
			else curr.offerFirst(left - right + "");
		}
		return Integer.parseInt(curr.pollFirst());
	}
