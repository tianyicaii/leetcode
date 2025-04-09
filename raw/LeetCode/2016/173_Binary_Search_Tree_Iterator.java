// https://leetcode.com/problems/binary-search-tree-iterator/


public class Solution {


	public class BSTIterator {
		
		private enum From { UP, LEFT, RIGHT };
		
		private class Frame {
			TreeNode node;
			From from;
			public Frame (TreeNode node, From from) {
				this.node = node;
				this.from = from;
			}
		}
		
		Deque<Frame> stack;
		
		public BSTIterator(TreeNode root) {
			stack = new ArrayDeque<>();
			if (root != null) stack.offerLast(new Frame(root, From.UP));
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	while (!stack.isEmpty()) {  // assume not empty
	    		
	    		Frame frame = stack.pollLast();
	    		TreeNode node = frame.node;
	    		From from = frame.from;
	    		
	    		if (from == From.UP) {
	    			frame.from = From.LEFT;
	    			stack.offerLast(frame);
	    			if (node.left != null) 
	    				stack.offerLast(new Frame(node.left, From.UP));  // keep going left
	    		}
	    		else if (from == From.LEFT) {
	    			int ans = node.val;
	    			if (node.right != null) 
	    				stack.offerLast(new Frame(node.right, From.UP));  // next one is right child
	    			return ans;  // got next
	    		}
	    		else {  // from == From.RIGHT
	    			;  // pop, done with this subtree
	    		}
	    	}
	    	return -1;  // should not reach here.
	    }
	}


}

