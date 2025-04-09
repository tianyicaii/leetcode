/*
 *  http://www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/
 *
 *  Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses)
 */


	public List<String> convertToRPN (String[] expression) {

		Stack<Deque<List<String>>> expr = new Stack<>();
		Deque<List<String>> curr = new ArrayDeque<>();
		
		for (String el : expression) {
			List<String> e = new ArrayList<>();
			e.add(el);

			if (Character.isDigit(el.charAt(0))) {
				
				if (curr.isEmpty()) curr.offerLast(e);
				else if (curr.peekLast().get(0).equals("+") || curr.peekLast().get(0).equals("-")) curr.offerLast(e);
				else {
					List<String> op = curr.pollLast();
					List<String> left = curr.pollLast();
					left.addAll(e);
					left.addAll(op);
					curr.offerLast(left);
				}
			}
			
			
			else if (el.equals("+") || el.equals("-")) curr.offerLast(e);
			else if (el.equals("*") || el.equals("/")) curr.offerLast(e);
			

			else if (el.equals("(")) {
				expr.push(curr);
				curr = new ArrayDeque<>();
			}
			
			
			else {  // ")"
				if (curr.isEmpty()) {
					curr = expr.pop();
					continue;
				}
				while (curr.size() != 1) {
					List<String> left = curr.pollFirst();
					List<String> op = curr.pollFirst();
					List<String> right = curr.pollFirst();
					left.addAll(right);
					left.addAll(op);
					curr.offerFirst(left);
				}
				
				
				List<String> sub = curr.pollFirst();
				curr = expr.pop();
				
				if (curr.isEmpty()) curr.offerLast(sub);
				else if (curr.peekLast().get(0).equals("+") || curr.peekLast().get(0).equals("-")) curr.offerLast(sub);
				else {
					List<String> op = curr.pollLast();
					List<String> left = curr.pollLast();
					left.addAll(sub);
					left.addAll(op);
					curr.offerLast(left);
				}
			}
		}
		
		if (curr.isEmpty()) return new ArrayList<>();
		
		while (curr.size() != 1) {
			List<String> left = curr.pollFirst();
			List<String> op = curr.pollFirst();
			List<String> right = curr.pollFirst();
			left.addAll(right);
			left.addAll(op);
			curr.offerFirst(left);
		}
		
		return curr.pollFirst();
	}
