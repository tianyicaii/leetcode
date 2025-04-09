/*
 *  http://www.lintcode.com/en/problem/convert-expression-to-polish-notation/
 *
 *  Given an expression string array, return the Polish notation of this expression. (remove the parentheses)
 */


	public List<String> convertToPN (String[] expression) {

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
					op.addAll(left);
					op.addAll(e);
					curr.offerLast(op);
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
					op.addAll(left);
					op.addAll(right);
					curr.offerFirst(op);
				}
				
				
				List<String> sub = curr.pollFirst();
				curr = expr.pop();
				
				if (curr.isEmpty()) curr.offerLast(sub);
				else if (curr.peekLast().get(0).equals("+") || curr.peekLast().get(0).equals("-")) curr.offerLast(sub);
				else {
					List<String> op = curr.pollLast();
					List<String> left = curr.pollLast();
					op.addAll(left);
					op.addAll(sub);
					curr.offerLast(op);
				}
			}
		}
		
		if (curr.isEmpty()) return new ArrayList<>();
		
		while (curr.size() != 1) {
			List<String> left = curr.pollFirst();
			List<String> op = curr.pollFirst();
			List<String> right = curr.pollFirst();
			op.addAll(left);
			op.addAll(right);
			curr.offerFirst(op);
		}
		
		return curr.pollFirst();
	}
