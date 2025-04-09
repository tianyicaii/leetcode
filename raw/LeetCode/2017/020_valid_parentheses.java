	
	public boolean isValid (String s) {
		Stack<Character> opens = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				opens.push(c);
			} else {
				if (opens.isEmpty()) return false;
				char left = opens.pop();
				if (c == ')' && left != '(' ||
						c == ']' && left != '[' ||
						c == '}' && left != '{')
					return false;
			}
		}
		return opens.isEmpty();
	}