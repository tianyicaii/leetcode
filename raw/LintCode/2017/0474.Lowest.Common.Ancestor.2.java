/*
 *  http://www.lintcode.com/en/problem/lowest-common-ancestor-ii/
 *
 *  Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *  The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *  The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 *  Parent tree, inversed binary tree
 */

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		Stack<ParentTreeNode> a = getPath(root, A);
		Stack<ParentTreeNode> b = getPath(root, B);
		ParentTreeNode ans = root;
		while (!a.isEmpty() && !b.isEmpty() && a.peek() == b.peek()) {
			ans = a.pop();
			b.pop();
		}
		return ans;
	}
	private Stack<ParentTreeNode> getPath (ParentTreeNode root, ParentTreeNode x) {
		Stack<ParentTreeNode> s = new Stack<>();
		while (x != null) {
			s.push(x);
			x = x.parent;
		}
		return s;
	}


	class ParentTreeNode {
		ParentTreeNode parent;
	}
