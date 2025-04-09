// https://leetcode.com/problems/closest-binary-search-tree-value-ii/


public class Solution {
	
	
	private class Pred {
		Deque<TreeNode> stack;
		public Pred (TreeNode root, double target) {
			stack = new ArrayDeque<>();
			while (root != null) {
				if (root.val == target) {
					stack.offerLast(root);  // represent it's left subtree
					break;  // no need to search further
				}
				else if (root.val < target) {
					stack.offerLast(root);
					root = root.right;  // might have closer
				}
				else {
					root = root.left;
				}
			}
		}
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		public int peek () {
			return stack.peekLast().val;
		}
		public int getNext() {
			TreeNode node = stack.pollLast();
			int ans = node.val;
			
			if (node.left != null) {
				node = node.left;
				while (node != null) {
					stack.offerLast(node);
					node = node.right;  // might have closer
				}
			}
			return ans;
		}
	}
	
	private class Succ {
		Deque<TreeNode> stack;
		public Succ (TreeNode root, double target) {
			stack = new ArrayDeque<>();
			while (root != null) {
				if (root.val == target) {
					stack.offerLast(root);
					break;  // no need to search further
				}
				else if (root.val > target) {
					stack.offerLast(root);
					root = root.left;  // might have closer
				}
				else {
					root = root.right;
				}
			}
		}
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		public int peek () {
			return stack.peekLast().val;
		}
		public int getNext() {
			TreeNode node = stack.pollLast();
			int ans = node.val;
			
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.offerLast(node);
					node = node.left;  // might have closer
				}
			}
			return ans;
		}
	}
	
	public List<Integer> closestKValues (TreeNode root, double target, int k) {
		List<Integer> ans = new ArrayList<>();
		Pred left = new Pred(root, target);
		Succ right = new Succ(root, target);
		if (left.hasNext() && right.hasNext() && left.peek() == right.peek()) {
			left.getNext();  // duplicate at target
		}
		while (k > 0) {
			
			if (!left.hasNext()) ans.add(right.getNext());
			else if (!right.hasNext()) ans.add(left.getNext());
			else if (Math.abs(target - left.peek()) < Math.abs(target - right.peek())) ans.add(left.getNext());
			else ans.add(right.getNext());
			
			k --;
		}
		return ans;
		
	}


}

