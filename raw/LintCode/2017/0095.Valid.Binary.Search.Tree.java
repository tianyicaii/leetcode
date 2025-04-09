/*
 *  http://www.lintcode.com/en/problem/validate-binary-search-tree/
 *
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 */


// recursion
	public boolean isValidBST (TreeNode root) {
		return helper(root, null, null);
	}
	boolean helper (TreeNode x, Integer left, Integer right) {
		if (x == null) return true;
		if (left != null && x.val <= left) return false;
		if (right != null && x.val >= right) return false;
		return helper(x.left, left, x.val) && helper(x.right, x.val, right);
	}


// in order traversal
	public boolean isValidBST (TreeNode root) {
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<>();  // node pushed to future processing
		TreeNode prev = null;  // previous node that should be smaller than current one
		while (curr != null || !s.isEmpty()) {
			if (curr == null) {
				curr = s.pop();
				if (prev != null && curr.val <= prev.val) return false;
				prev = curr;
				curr = curr.right;  // then go right
			} else {
				s.push(curr);
				curr = curr.left;  // first go left
			}
		}
		return true;
	}
