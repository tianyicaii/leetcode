
class MinStack {

	Stack<Integer> N = new Stack<>();
	Stack<Integer> M = new Stack<>();

	public MinStack() {

	}

	public void push(int x) {
		N.push(x);
		if (M.isEmpty() || x <= M.peek())
			M.push(x);
	}

	public void pop() {
		int x = N.pop();
		if (M.peek() == x)
			M.pop();
	
	}

	public int top() {
		return N.peek();
	}

	public int getMin() {
		return M.peek();
	}
}
