/*
 *  http://www.lintcode.com/en/problem/min-stack/
 *
 *  Implement a stack with min() function, which will return the smallest number in the stack.
 *  It should support push, pop and min operation all in O(1) cost.
 */


	public class MinStack {

		Stack<Integer> nums;
		Stack<Integer> mins;

		public MinStack () {
			nums = new Stack<>();
			mins = new Stack<>();
		}

		public void push (int number) {
			nums.push(number);
			if (mins.isEmpty() || mins.peek() >= number) mins.push(number);
		}

		public int pop () {
			int number = nums.pop();
			if (number == mins.peek()) mins.pop();
			return number;
		}

		public int min () {
			return mins.peek();
		}
	}
