/*
 *  http://www.lintcode.com/en/problem/implement-stack-by-two-queues/
 *
 *  Implement a stack by two queues. The queue is first in first out (FIFO).
 *  That means you can not directly pop the last element in a queue.
 */

	public class Stack {
		
		Queue<Integer> q = new LinkedList<>();

		public void push(int x) {
			q.offer(x);
		}

		public int pop2 () {
			if (isEmpty()) throw new RuntimeException("empty");
			int sz = q.size();
			for (int i = 0; i < sz - 1; i++) {
				q.offer(q.poll());
			}
			return q.poll();
		}

		public void pop() {
			pop2();
		}

		public int top() {
			int ans = pop2();
			q.offer(ans);
			return ans;
		}

		public boolean isEmpty() {
			return q.size() == 0;
		}
	}
