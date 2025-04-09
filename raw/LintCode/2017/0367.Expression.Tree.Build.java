/*
 *  https://www.jiuzhang.com/solution/expression-tree-build/
 *
 *  The structure of Expression Tree is a binary tree to evaluate certain expressions.
 *  All leaves of the Expression Tree have an number string value.
 *  All non-leaves of the Expression Tree have an operator string value.
 *  Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.
 */


	public ExpressionTreeNode build (String[] expression) {
		
		// simplify by adding one more pair of parentheses
		String[] tmp = expression;
		expression = new String[tmp.length + 2];
		System.arraycopy(tmp, 0, expression, 1, tmp.length);
		expression[0] = "(";
		expression[expression.length - 1] = ")";
		
		
		Stack<Deque<ExpressionTreeNode>> expr = new Stack<>();  // stack handling parenthesis
		Deque<ExpressionTreeNode> curr = new ArrayDeque<>();  // deque for sub-expression in side parenthesis, (plus / minus).
		
		
		for (String e : expression) {
			
			
			if (Character.isDigit(e.charAt(0))) {
				ExpressionTreeNode num = new ExpressionTreeNode(e);
				if (curr.isEmpty()) curr.offerLast(num);  // first element at this level
				else if (curr.peekLast().symbol.equals("+") || curr.peekLast().symbol.equals("-")) curr.offerLast(num);  // hold on until * and / are handled
				else curr.peekLast().right = num;  // if number follows * or / then it must be an operand of that operator
			}

			else if (e.equals("+") || e.equals("-")) curr.offerLast(new ExpressionTreeNode(e));

			else if (e.equals("*") || e.equals("/")) {  // number to the left must be its operand
				ExpressionTreeNode md = new ExpressionTreeNode(e);
				md.left = curr.pollLast();
				curr.offerLast(md);
			}

			else if (e.equals("(")) {
				expr.push(curr);  // hold on prefix
				curr = new ArrayDeque<>();  // start a new sub-expression
			}

			else {  // ")"
				if (curr.isEmpty()) {  // in case "(" is immediately followed by ")", ignore this pair of parentheses
					curr = expr.pop();
					continue;
				}
				while (curr.size() != 1) {  // perform + and -
					ExpressionTreeNode l = curr.pollFirst();
					ExpressionTreeNode pm = curr.pollFirst();
					ExpressionTreeNode r = curr.pollFirst();
					pm.left = l;
					pm.right = r;
					curr.offerFirst(pm);
				}
				ExpressionTreeNode num = curr.pollFirst();  // result of the parenthesized expression
				curr = expr.pop();  // get back enclosing expression
				if (curr.isEmpty()) curr.offerLast(num);  // treat parenthesized expression like a number
				else if (curr.peekLast().symbol.equals("+") || curr.peekLast().symbol.equals("-")) curr.offerLast(num);
				else curr.peekLast().right = num;
			}
		}
		
		if (curr.isEmpty()) return null;
		return curr.pollFirst();
	}
