// https://leetcode.com/problems/min-stack/


public class Solution {
	

	public class MinStack {

		Deque<Integer> nums;
		Deque<Integer> mins;
		
	    /** initialize your data structure here. */
	    public MinStack() {
	    	nums = new ArrayDeque<>();
	    	mins = new ArrayDeque<>();
	    }
	    
	    public void push(int x) {
	        nums.offerLast(x);
	        if (mins.isEmpty() || x <= mins.peekLast())
	        	mins.offerLast(x);
	    }
	    
	    public void pop() {
	        int x = nums.pollLast();
	        if (x == mins.peekLast())
	        	mins.pollLast();
	    }
	    
	    public int top() {
	        return nums.peekLast();
	    }
	    
	    public int getMin() {
	        return mins.peekLast();
	    }
	}


}

