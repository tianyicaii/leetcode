/*
 *  http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
 *
 *  Given a binary tree, return the inorder traversal of its nodes' values.
 */

	public ArrayList<Integer> inorderTraversal (TreeNode root) {
		if (root == null) return new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ans.addAll(inorderTraversal(root.left));
		ans.add(root.val);
		ans.addAll(inorderTraversal(root.right));
		return ans;
	}

	public ArrayList<Integer> inorderTraversal (TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		while (!(curr == null && s.isEmpty())) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;  // go left first
			} else {
				curr = s.pop();  // go back when left is exhausted
				ans.add(curr.val);
				curr = curr.right;  // then go right
			}
		}
		return ans;
	}

