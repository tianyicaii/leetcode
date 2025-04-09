/*
 *  http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
 *
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 */

	ArrayList<Integer> ans;
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ans = new ArrayList<>();
		helper(root);
		return ans;
	}
	
	private void helper (TreeNode root) {
		if (root == null) return;
		helper(root.left);
		helper(root.right);
		ans.add(root.val);
	}


// iterative: in post-order traversal, there is no more than one link jump,
// keep track of previous visited node, and compare it with neighbors, (parent, left child, right child,)
// to determine the next move.

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		Stack<TreeNode> s = new Stack<>();
		
		TreeNode dummy = new TreeNode(0);
		dummy.right = root;
		s.push(root);
		TreeNode prev = dummy;  // previous visited node 
		
		while (!s.isEmpty()) {
			
			TreeNode curr = s.pop();
			
			
			if (curr == prev.left || curr == prev.right) {  // going down
				if (curr.left != null) {
					s.push(curr);
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr);
					s.push(curr.right);
				} else {
					ans.add(curr.val);
				}
			} else if (curr.left == prev) {  // done left
				if (curr.right != null) {
					s.push(curr);
					s.push(curr.right);
				} else {
					ans.add(curr.val);
				}	
			} else {  // curr.right = prev
				ans.add(curr.val);
			}
			
			
			prev = curr;
		}
		
		
		return ans;
	}


// iterative
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> path = new Stack<>();
		TreeNode curr = root;
		TreeNode prev = null;
		while (curr != null || !path.isEmpty()) {
			
			if (curr != null) {
				path.push(curr);
				prev = curr;
				curr = curr.left;  // first go left
				
			} else {  // hit null, retreat
				curr = path.pop();
				if (prev == curr) {
					if (curr.right != null) {  // [CAUTION]: cannot let right hit null, otherwise cannot distinguish left null from right null
						path.push(curr);
						curr = curr.right;
					} else {
						ans.add(curr.val);
						curr = null;  // keep retreating, prev points to left child now
					}
				} else if (prev == curr.left) {
					if (curr.right != null) {
						path.push(curr);
						curr = curr.right;
					} else {
						ans.add(curr.val);
						prev = curr;
						curr = null;  // keep retreating
					}
				} else {  // prev == curr.right
					ans.add(curr.val);
					prev = curr;
					curr = null;
				}
			}
						
		}
		return ans;
	}
