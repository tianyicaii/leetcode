// https://leetcode.com/problems/binary-tree-inorder-traversal/


public class Solution {
	

	private enum From { UP, LEFT, RIGHT }
	private class Frame {
		TreeNode node;
		From f;
		public Frame (TreeNode node, From f) {
			this.node = node;
			this.f = f;
		}
	}
	
	public List<Integer> inorderTraversal (TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		Deque<Frame> stack = new ArrayDeque<>();
		stack.offerLast(new Frame(root, From.UP));
		
		while (!stack.isEmpty()) {
			Frame frame = stack.pollLast();
			if (frame.f == From.UP) {
				frame.f = From.LEFT;  // will return from left child
				stack.offerLast(frame);
				if (frame.node.left != null) stack.offerLast(new Frame(frame.node.left, From.UP));
			}
			else if (frame.f == From.LEFT) {
				frame.f = From.RIGHT;  // will return from left child
				stack.offerLast(frame);
				if (frame.node.right != null) stack.offerLast(new Frame(frame.node.right, From.UP));
				ans.add(frame.node.val);
			}
			else {  // returned from right
				;   // popped.
			}
		}
		
		return ans;
	}	
	

}

