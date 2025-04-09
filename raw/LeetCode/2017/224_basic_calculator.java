// https://leetcode.com/problems/basic-calculator/description/

	public int calculate (String s) {

		s = '(' + s + ')';
		List<String> expr = new ArrayList<>();
		
		StringBuilder num = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) continue;
			else if (Character.isDigit(c)) num.append(c);
			
			else if (c == '+' || c == '-') {
				if (expr.isEmpty() || !expr.get(expr.size() - 1).equals(")")) {
					if (num.length() == 0) expr.add("0");  // in case "(-1)"
					else expr.add(num.toString());  // finishing previous operand
					num = new StringBuilder();
				}
				expr.add(c + "");
			}
			else if (c == '(') {
				expr.add(c + "");
			}
			else {  // ")"
				if (num.length() != 0) {
					expr.add(num.toString());
					num = new StringBuilder();
				}
				expr.add(c + "");
			}
		}
			
		
		Stack<Deque<String>> prevExpr = new Stack<>();
		Deque<String> currExpr = new ArrayDeque<>();

		for (String e : expr) {
			if (e.equals("(")) {
				prevExpr.push(currExpr);
				currExpr = new ArrayDeque<>();
			} else if (e.equals(")")){
				int subVal = helper(currExpr);
				currExpr = prevExpr.pop();
				currExpr.offerLast(subVal + "");
			} else {  // "+" or "-"
				currExpr.offerLast(e);
			}
		}
		
		return helper(currExpr);
	}
	
	private int helper (Deque<String> expr) {  // an expression without '(' or ')'
		if (expr.isEmpty()) return 0;
		while (expr.size() != 1) {
			int left = Integer.parseInt(expr.pollFirst());
			String operator = expr.pollFirst();
			int right = Integer.parseInt(expr.pollFirst());
			if (operator.equals("+")) expr.offerFirst(left + right + "");
			else expr.offerFirst(left - right + "");
		}
		return Integer.parseInt(expr.pollFirst());
	}
