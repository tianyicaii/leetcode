/*
 *  http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/
 *
 *  As the title described, you should only use two stacks to implement a queue's actions.
 *  The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 *  Both pop and top methods should return the value of first element.
 */


public class MyQueue {

	Stack<Integer> out;
	Stack<Integer> in;

	public MyQueue () {
		out = new Stack<>();
		in  = new Stack<>();
	}


	public void push (int element) {
		in.push(element);
	}


	public int pop () {
		top();
		return out.pop();
	}


	public int top () {
		if (out.isEmpty()) dump();
		return out.peek();
	}

	private void dump () {
		while (!in.isEmpty())
			out.push(in.pop());
	}
}
