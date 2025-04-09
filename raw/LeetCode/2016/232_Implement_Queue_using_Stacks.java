// https://leetcode.com/problems/implement-queue-using-stacks/


public class Solution {


	class MyQueue {
	    
		Deque<Integer>  in = new ArrayDeque<>();
		Deque<Integer> out = new ArrayDeque<>();
		
		
	    // Push element x to the back of queue.
	    public void push(int x) {
			in.offerLast(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	    	dump();
	    	out.pollLast();
	    }

	    // Get the front element.
	    public int peek() {
	    	dump();
	    	return out.peekLast();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	    	dump();
	    	return out.isEmpty();
	    }
	    
	    private void dump () {
	    	if (out.isEmpty())  // do not dump if out is not empty.
	    		while (!in.isEmpty()) 
	    			out.offerLast(in.pollLast());
	    }
	}


}

