

	public TreeNode upsideDownBinaryTree (TreeNode root) {

		//  this is more of a linked list than a binary tree.
			
		TreeNode p = root;
		TreeNode q = null;
		root = null;  //  bring p to root
		
		while (p != null) {
			
			TreeNode pl = p.left;
			TreeNode pr = p.right;
			
			p.right = root;
			p.left = q;
			root = p;
			
			p = pl;
			q = pr;
		}
		
		
		return root;
	}
