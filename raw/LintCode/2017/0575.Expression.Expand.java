/*
 *  http://www.lintcode.com/en/problem/expression-expand/
 *
 *  Given an expression s includes numbers, letters and brackets.
 *  Number represents the number of repetitions inside the brackets(can be a string or another expression)
 *  Please expand expression to be a string.
 */


// using stack to handle parentheses. 


	public String expressionExpand (String s) {

		Stack<Integer> counts = new Stack<>();
		Stack<StringBuilder> prefixes = new Stack<>();

		int cnt = 0;
		StringBuilder p = new StringBuilder();  // current level
		
		int i = 0;
		while (i < s.length()) {
			
			char c = s.charAt(i++);
			
			if (Character.isDigit(c)) {
				cnt = cnt * 10 + (c - '0');  // get whole number


			} else if (c == '[') {  // start a new level
				counts.push(cnt);
				cnt = 0;
				prefixes.push(p);
				p = new StringBuilder();
			

			} else if (c == ']') {  // done with current level
				int numCopies = counts.pop();
				StringBuilder pred = prefixes.pop();
				for (int j = 0; j < numCopies; j++) {
					pred.append(p.toString());
				}
				p = pred;  // resume previous level
			

			} else {  // normal letters
				p.append(c);
			}

		}

		
		return p.toString();	
	}
