// https://leetcode.com/problems/implement-stack-using-queues/


public class Solution {


	class MyStack {
	    	    
		// similar to bfs
		Queue<Integer> q = new LinkedList<>();
	    
	    
	    // Push element x onto stack.
	    public void push(int x) {
	    	int sz = q.size();
	    	q.offer(x);
	    	for (int i = 0; i < sz; i++) {
	    		q.offer(q.poll());  // rolling around
	    	}
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	    	q.poll();
	    }

	    // Get the top element.
	    public int top() {
	    	return q.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	    	return q.isEmpty();
	    }
	}	


}

