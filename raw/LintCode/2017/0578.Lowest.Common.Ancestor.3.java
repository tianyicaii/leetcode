/*
 *  http://www.lintcode.com/en/problem/lowest-common-ancestor-iii/
 *
 *  Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *  The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *  Return null if LCA does not exist.
 *  Node A or node B may not exist in tree, need to distinguish finding one node from finding both nodes.
 */

// recursion
	TreeNode ans;
	public TreeNode lowestCommonAncestor3 (TreeNode root, TreeNode A, TreeNode B) {
		ans = null;
		helper(root, A, B);
		return ans;
	}
	
	int helper (TreeNode root, TreeNode A, TreeNode B) {  // return number of targets seen under this node
		if (root == null) return 0;
		int cnt = 0;
		if (root == A) cnt += 1;
		if (root == B) cnt += 1;
		cnt += helper(root.left, A, B);
		cnt += helper(root.right, A, B);  // recursion calls might set ans
		if (ans == null && cnt == 2) ans = root;  // see both target the first time
		return cnt;
	}



// pre-order traversal
	public TreeNode lowestCommonAncestor3 (TreeNode root, TreeNode A, TreeNode B) {
		Stack<TreeNode> a = getPath(root, A);
		Stack<TreeNode> b = getPath(root, B);
		if (a.isEmpty() || b.isEmpty()) return null;  // not found
		while (a.size() != b.size())
			if (a.size() > b.size()) a.pop();
			else b.pop();
		while (a.peek() != b.peek()) {
			a.pop();
			b.pop();
		}
		return a.peek();
	}

	private Stack<TreeNode> getPath (TreeNode root, TreeNode x) {
		Stack<TreeNode> path = new Stack<>();
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<>();
		while (curr != null || !s.isEmpty()) {  // still have node to check
			if (curr == null) {  // left subtree is done, go back to right subtree
				curr = s.pop();
				while (path.peek().right != curr) path.pop();  // pop the left branch
			}
			
			// process this node, either got it from stack or follow the left branch
			
			if (curr == x) {  // found
				path.push(x);
				return path;
			}

			if (curr.right != null) s.push(curr.right);  // process it later
			path.push(curr);  // record path
			curr = curr.left;  // check left first
		}
		return new Stack<>();  // not found; however, path is not empty
	}
