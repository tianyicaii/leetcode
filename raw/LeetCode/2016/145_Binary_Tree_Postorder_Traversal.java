// https://leetcode.com/problems/binary-tree-postorder-traversal/


public class Solution {
	

	private enum From { UP, LEFT, RIGHT }
	
	private class Frame {
		TreeNode node;
		From from;
		public Frame (From from, TreeNode node) {
			this.from = from;
			this.node = node;
		}
	}
	
	public List<Integer> postorderTraversal (TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		
		Deque<Frame> stack = new ArrayDeque<>();
		stack.offerLast(new Frame(From.UP, root));
		
		while (!stack.isEmpty()) {
			Frame frame = stack.pollLast();
			TreeNode node = frame.node;
			From from = frame.from;
			if (from == From.UP) {
				frame.from = From.LEFT;
				stack.offerLast(frame);
				if (node.left != null) stack.offerLast(new Frame(From.UP, node.left));
			}
			else if (from == From.LEFT) {
				frame.from = From.RIGHT;
				stack.offerLast(frame);
				if (node.right != null) stack.offerLast(new Frame(From.UP, node.right));
			}
			else {  // from RIGHT
				ans.add(node.val);  // post order
			}
		}
		return ans;
	}	


}

