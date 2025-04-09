/*
 *  http://www.lintcode.com/en/problem/flatten-binary-tree-to-linked-list/
 *
 *  Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *  Here we use the right pointer in TreeNode as the next pointer in ListNode.
 */




// pre-order traversal, look back to previous node
	public void flatten (TreeNode root) {
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<>();  // push right subtree on stack for later processing
		TreeNode prev = null;  // to link current subtree to root
		while (curr != null || !s.isEmpty()) {
			if (curr == null) curr = s.pop();  // start to process most recent right subtree
			if (curr.right != null) s.push(curr.right);  // push right subtree on stack for later processing
			curr.right = curr.left;  // process root for current subtree
			curr.left = null;
			if (prev != null) prev.right = curr;
			prev = curr;
			curr = curr.right;  // go "left", left and right have been switched.
		}
	}	




// pre-order traversal, look ahead to the next node
	public void flatten (TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode x = s.pop();
			if (x.right != null) s.push(x.right);
			if (x.left != null) s.push(x.left);
			x.left = null;
			if (!s.isEmpty()) x.right = s.peek();  // next node is the top of list
		}
	}	




// recursion, bottom up
	public void flatten (TreeNode root) {
		if (root == null) return;
		helper(root);
	}

	TreeNode helper (TreeNode root) {  // returns the tail of list
		if (root.left == null && root.right == null) return root;
		if (root.left == null) return helper(root.right);  // nothing to do at this node
		if (root.right == null) {
			root.right = root.left;
			root.left = null;
			return helper(root.right);
		}
		// root.left != null && root.right != null
		TreeNode leftTail = helper(root.left);
		TreeNode rightTail = helper(root.right);
		leftTail.right = root.right;
		root.right = root.left;
		root.left = null;
		return rightTail;
	}
	