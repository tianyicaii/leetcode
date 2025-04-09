/*
 *  http://www.lintcode.com/en/problem/inorder-successor-in-binary-search-tree/
 *
 *  Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 *  If the given node has no in-order successor in the tree, return null
 *  It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
 */


// iterative
	public TreeNode inorderSuccessor (TreeNode root, TreeNode p) {
		TreeNode pred = null;  // potential next larger one
		TreeNode curr = root;
		while (curr != null) {  // find p
			if (curr == p) break;
			else if (curr.val > p.val) {
				pred = curr;
				curr = curr.left;
			}
			else curr = curr.right;
		}

		// curr == p
		if (curr == null) return null;
		else if (curr.right != null) {
			curr = curr.right;
			while (curr.left != null) curr = curr.left;
			return curr;
		} else return pred;
	}


// recursion
	public TreeNode inorderSuccessor (TreeNode root, TreeNode p) {
		if (root == null) return null;
		if (root == p) {
			if (root.right != null) {
				return inorderSuccessor(root.right, p);
			} else {
				return null;
			}
		} else if (root.val > p.val) {
			TreeNode suc = inorderSuccessor(root.left, p);
			if (suc == null) return root;
			else return suc;
		} else return inorderSuccessor(root.right, p);
	}
