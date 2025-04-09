/*
 *  http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 *
 *  Given a binary tree, return the preorder traversal of its nodes' values.
 */

	ArrayList<Integer> ans;
	public ArrayList<Integer> preorderTraversal (TreeNode root) {
		ans = new ArrayList<Integer>();
		helper(root);
		return ans;
	}
	void helper (TreeNode x) {
		if (x == null) return;
		ans.add(x.val);
		helper(x.left);
		helper(x.right);
	}


	public ArrayList<Integer> preorderTraversal (TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<>();
		while (curr != null || !s.isEmpty()) {
			if (curr == null) curr = s.pop();
			ans.add(curr.val);
			if (curr.right != null) s.push(curr.right);
			curr = curr.left;
		}
		return ans;
	}	


	public ArrayList<Integer> preorderTraversal (TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode x = s.pop();
			ans.add(x.val);
			if (x.right != null) s.push(x.right);
			if (x.left != null) s.push(x.left);
		}
		return ans;
	}
