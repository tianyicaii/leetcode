

	public int evalRPN (String[] tokens) {
		Stack<String> o = new Stack<>();
		for (String t : tokens) {
			if (t.equals("+")) {
				int b = Integer.parseInt(o.pop());
				int a = Integer.parseInt(o.pop());
				o.push(a + b + "");				
			} else if (t.equals("-")) {
				int b = Integer.parseInt(o.pop());
				int a = Integer.parseInt(o.pop());
				o.push(a - b + "");
			} else if (t.equals("*")) {
				int b = Integer.parseInt(o.pop());
				int a = Integer.parseInt(o.pop());
				o.push(a * b + "");
			} else if (t.equals("/")) {
				int b = Integer.parseInt(o.pop());
				int a = Integer.parseInt(o.pop());
				o.push(a / b + "");
			} else {  //  number
				o.push(t);
			}
		}
		return Integer.parseInt(o.pop());
	}

	